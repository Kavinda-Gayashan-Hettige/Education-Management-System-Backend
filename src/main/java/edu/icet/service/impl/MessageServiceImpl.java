package edu.icet.service.impl;

import edu.icet.model.entity.Message;
import edu.icet.repository.MessageRepository;
import edu.icet.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Message sendMessage(Message message) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm a");
        message.setTime(LocalTime.now().format(dtf));
        message.setDate(LocalDate.now());
        message.setRead(false);

        return messageRepository.save(message);
    }

    @Override
    public boolean markAsRead(Long id) {
        return messageRepository.findById(id)
                .map(msg -> {
                    msg.setRead(true);
                    messageRepository.save(msg);
                    return true;
                }).orElse(false);
    }

    @Override
    public List<Message> getMessagesBySender(String sender) {
        System.out.println("Sender is: " + sender);
        return messageRepository.findBySender(sender);

    }
}