/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.shoelit.ecommerce.repository;

import com.shoelit.ecommerce.entity.ERole;
import com.shoelit.ecommerce.entity.Roles;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author itcrc
 */
public interface RoleRepo extends JpaRepository<Roles, Long>{
    Optional<Roles> findByName(ERole name);
}
