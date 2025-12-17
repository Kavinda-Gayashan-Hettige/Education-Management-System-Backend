package edu.icet.controller;

import edu.icet.model.dto.ParentDto;
import edu.icet.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parent")
@RequiredArgsConstructor
public class ParentController {
    final ParentService service;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addParent(@RequestBody ParentDto parent) {
        service.addParent(parent);
    }
}
