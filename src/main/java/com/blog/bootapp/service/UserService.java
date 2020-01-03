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

    public void save(User user)
    {
        repo.save(user);
    }
    public boolean newUserName(String UserName)
    {
        List<User> userList=listAll();
        for(int i=0;i<userList.size();i++)
        {
            if(UserName.equals(userList.get(i).getName()))
            {
                return false;
            }
        }
        return true;
    }
}