package com.shoelit.ecommerce.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoelit.ecommerce.entity.User;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Ronn Kevin Rubio
 */
public class UserDetailsImpl implements UserDetails {

    private Long id;
    private String email;
    private String firstname;
    private String middlename;
    private String lastname;
    private String gender;
    private Integer age;
    @JsonIgnore
    private String password;
    
    private Collection<? extends GrantedAuthority> authorities; 
    
        public UserDetailsImpl(Long id, String email, String firstname, String middlename, String lastname, String gender, Integer age, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
        this.password = password;
        this.authorities = authorities;
    }
        
    public static UserDetailsImpl build(User user){
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        return new UserDetailsImpl(
                
                user.getId(),
                user.getEmail(),
                user.getFirstname(),
                user.getMiddlename(),
                user.getLastname(),
                user.getGender(),
                user.getAge(),
                user.getPassword(),
                authorities);

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities; 
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public Long getId(){
        return id;
    }
}
