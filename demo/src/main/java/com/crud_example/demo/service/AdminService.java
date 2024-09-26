package com.crud_example.demo.service;

import com.crud_example.demo.model.Admin;
import com.crud_example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    //create admin
    public Admin saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }
    //get all admins
    public List<Admin> getAllAdmin(){
        return adminRepository .findAll();
    }
    //get admin by id
    public Optional<Admin> getAdminById(Long id){
        return adminRepository.findById(id);
    }
    // update admin

    public Admin updateAdmin(Long id, Admin updateAdmin){
        Admin admin = adminRepository.findById(id).orElseThrow();
        admin.setName(updateAdmin.getName());
        admin.setEmail(updateAdmin.getEmail());
        return adminRepository.save(admin);
    }
    public void deleteAdminById(Long id){
        adminRepository.deleteById(id);
    }

}
