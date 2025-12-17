package edu.icet.service.impl;

import edu.icet.model.dto.ParentDto;
import edu.icet.model.entity.Parent;
import edu.icet.repository.ParentRepository;
import edu.icet.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
    ParentRepository repository;
    ModelMapper mapper;

    @Override
    public void addParent(ParentDto parent) {
            repository.save(mapper.map(parent, Parent.class));
    }

    @Override
    public void updateParent(ParentDto parent) {
        repository.save(mapper.map(parent, Parent.class));
    }

    @Override
    public void deleteParent(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<ParentDto> getAllParents() {

        List<Parent> parents = repository.findAll();

        return parents.stream()
                .map(parent -> mapper.map(parent, ParentDto.class))
                .toList();
    }

    @Override
    public ParentDto getParentById(Integer id) {

        Parent parent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found with id: " + id));

        return mapper.map(parent, ParentDto.class);
    }


}
