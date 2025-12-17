package edu.icet.service;

import edu.icet.model.dto.ParentDto;

import java.util.List;

public interface ParentService {
    void addParent(ParentDto parent);

    void updateParent(ParentDto parent);

    void deleteParent(Integer id);

    List<ParentDto> getAllParents();

    ParentDto getParentById(Integer id);
}
