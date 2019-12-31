package com.blog.bootapp.repository;

import com.blog.bootapp.model.Category;
import com.blog.bootapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>
{

}