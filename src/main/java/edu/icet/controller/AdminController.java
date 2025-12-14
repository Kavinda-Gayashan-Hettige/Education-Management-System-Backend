package edu.icet.controller;

import edu.icet.model.dto.AdminDto;
import edu.icet.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin
public class AdminController {

    final AdminService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAdmin(@RequestBody AdminDto admin) {
        service.addAdmin(admin);
        System.out.println(admin);
    }
}