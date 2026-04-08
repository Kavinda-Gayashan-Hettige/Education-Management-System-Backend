package edu.icet.service;

import edu.icet.model.entity.Message;
import java.util.List;

public interface MessageService {
    List<Message> getAllMessages();
    Message sendMessage(Message message);
    boolean markAsRead(Long id);
    List<Message> getMessagesBySender(String sender);
}