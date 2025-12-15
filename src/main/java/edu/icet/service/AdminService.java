package edu.icet.service;

import edu.icet.model.dto.AdminDto;

public interface AdminService {
    void addAdmin(AdminDto admin);

    void deleteAdmin(Integer adminID);

    void updateAdmin(AdminDto admin);
}
