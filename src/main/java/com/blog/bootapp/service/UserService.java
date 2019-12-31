package com.blog.bootapp.service;


import com.blog.bootapp.repository.UserRepository;
import com.blog.bootapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class UserService {
    @Autowired
    public UserRepository repo;

    public List<User> listAll() { return (List<User>) repo.findAll();}

    public User get(Long id) {
        return repo.findById(id).get();
    }

}