package com.blog.bootapp.repository;

import com.blog.bootapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{
    @Query("select u from User u where u.name= :name")
    Optional<User> findByUserName(String name);

//    @Query("select u.userId from User u where u.name= :name")
//    long getAuthorIdByUsername(String username);
}