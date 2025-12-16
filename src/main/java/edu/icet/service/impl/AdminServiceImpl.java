package edu.icet.service.impl;

import edu.icet.model.dto.AdminDto;
import edu.icet.model.entity.Admin;
import edu.icet.repository.AdminRepository;
import edu.icet.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    final AdminRepository repository;
    final ModelMapper mapper;
    @Override
    public void addAdmin(AdminDto admin) {

            repository.save(mapper.map(admin, Admin.class));

    }

    @Override
    public void deleteAdmin(Integer adminID) {
        repository.deleteById(adminID);
    }

    @Override
    public void updateAdmin(AdminDto admin) {

        repository.save(mapper.map(admin, Admin.class));
    }

    @Override
    public List<AdminDto> getAll() {
        List<AdminDto> customerList = new ArrayList<>();
        List<Admin> all = repository.findAll();

        all.forEach(adminEntity -> {
            customerList.add(mapper.map(adminEntity, AdminDto.class));
        });

        return customerList;
    }
}
