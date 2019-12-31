package com.blog.bootapp.service;

import com.blog.bootapp.repository.CategoryRepository;
import com.blog.bootapp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class CategoryService {
    @Autowired
    public CategoryRepository repo;

    public void save(Category cat) {
        repo.save(cat);
    }

    public List<Category> listAll() { return (List<Category>) repo.findAll();}

    public Category get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}