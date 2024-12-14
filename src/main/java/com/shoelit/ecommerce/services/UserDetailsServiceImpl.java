/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoelit.ecommerce.services;

import com.shoelit.ecommerce.entity.User;
import com.shoelit.ecommerce.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author itcrc
 */
public class UserDetailsServiceImpl implements UserDetailsService{

    private UserRepo userRepo;
    
    public UserDetailsServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found with email" + username));
       return UserDetailsImpl.build(user);
    }
    
}
