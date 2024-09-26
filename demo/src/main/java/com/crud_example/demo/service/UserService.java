package com.crud_example.demo.service;

import com.crud_example.demo.model.User;
import com.crud_example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //create user
    public User saveUser(User user){
        return userRepository.save(user);
    }

    //Read All Users
    public List<User> getAllUses(){
        return userRepository.findAll();
    }

    //Read User by ID
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    //update User
    public User updateUser(Long id, User updateUser){
        User user = userRepository.findById(id).orElseThrow();
        user.setName(updateUser.getName());
        user.setEmail(updateUser.getEmail());
        return userRepository.save(user);
    }

    //delete user
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
