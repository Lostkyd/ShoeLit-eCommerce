/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoelit.ecommerce.services;

import com.shoelit.ecommerce.entity.User;
import com.shoelit.ecommerce.repository.UserRepo;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ronn Kevin Rubio
 */
@Service
public class UserService {
    private UserRepo userRepo;
    
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    
    public User createUser(User user){
        if(userRepo.findByEmail(user.getEmail()).isPresent()){
            throw new IllegalArgumentException("Email already exist.");
    }
        return userRepo.save(user);
    }
    public Optional<User> getUserById(Long id){
        return userRepo.findById(id);
    }
}