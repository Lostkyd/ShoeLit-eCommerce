/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoelit.ecommerce.dto;

import lombok.Data;

/**
 *
 * @author Ronn Kevin Rubio
 */

@Data
public class SignupRequest {
    private String email;
    private String firstname;
    private String middlename;
    private String lastname;
    private String gender;
    private Integer age;
    private String password;
}
