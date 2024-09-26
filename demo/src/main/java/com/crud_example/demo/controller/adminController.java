package com.crud_example.demo.controller;

import com.crud_example.demo.model.Admin;
import com.crud_example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class adminController {
    @Autowired
    private AdminService adminService;

    //create admin
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }
    //get all admin
    @GetMapping
    public List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }
    //get admin by id
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id){
        Optional<Admin> admin = adminService.getAdminById(id);
        return admin.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin updateAdmin){
        return ResponseEntity.ok(adminService.updateAdmin(id,updateAdmin));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id){
        adminService.deleteAdminById(id);
        return ResponseEntity.noContent().build();
    }

}
