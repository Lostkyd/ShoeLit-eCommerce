/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.shoelit.ecommerce.repository;

import com.shoelit.ecommerce.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ronn Kevin Rubio
 */
public interface UserRepo extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
