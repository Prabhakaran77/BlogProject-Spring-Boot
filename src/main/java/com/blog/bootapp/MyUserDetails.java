package com.blog.bootapp;

import com.blog.bootapp.controller.HomeController;
import com.blog.bootapp.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.blog.bootapp.controller.HomeController.*;

public class MyUserDetails implements UserDetails {

    private final String userName;
    private final String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(User userName)
    {
        this.userName=userName.getName();
        this.password=userName.getPassword();
        this.active=userName.isActive();
        this.authorities=Arrays.stream(userName.getRoles().split(","))
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
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
        return userName;
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
        return active;
    }

    public String getUserName() {
        return userName;
    }
}
