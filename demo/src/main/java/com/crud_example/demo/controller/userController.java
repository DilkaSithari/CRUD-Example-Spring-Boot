package com.crud_example.demo.controller;

import com.crud_example.demo.model.User;
import com.crud_example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class  userController {
    @Autowired
    private UserService userService;

    //create user
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    //get all users
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUses();
    }

    //get user by Id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    //update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updateUser){
        return ResponseEntity.ok(userService.updateUser(id,updateUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
