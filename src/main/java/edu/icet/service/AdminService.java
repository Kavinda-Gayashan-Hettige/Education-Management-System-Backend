package edu.icet.service;

import edu.icet.model.dto.AdminDto;

import java.util.List;

public interface AdminService {
    void addAdmin(AdminDto admin);

    void deleteAdmin(Integer adminID);

    void updateAdmin(AdminDto admin);

    List<AdminDto> getAll();
}
