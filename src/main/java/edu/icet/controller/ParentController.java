package edu.icet.controller;

import edu.icet.model.dto.ParentDto;
import edu.icet.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateParent(@RequestBody ParentDto parent) {
        service.updateParent(parent);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParent(@PathVariable Integer id) {
        service.deleteParent(id);
    }

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<ParentDto> getAllParents() {
        return service.getAllParents();
    }
}
