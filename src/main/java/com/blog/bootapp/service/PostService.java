package com.blog.bootapp.service;

import com.blog.bootapp.controller.HomeController;
import com.blog.bootapp.repository.PostRepository;
import com.blog.bootapp.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
//@Transactional
public class PostService {
    @Autowired
    public PostRepository repo;

    public void save(Post post) {
        repo.save(post);
    }

    public Post get(Long id)
    {
        System.out.println("entered method");
        Post post=repo.getById(id);
        System.out.println("b4 return");
        return post;
    }

    public Page<Post> find(PageRequest gotoPage)
    {
        return repo.findAll(gotoPage);
    }

    public void delete(Long id)
    {
        repo.deleteById(id);
    }

    public List<Post> findAll()
    {
       return repo.findAll();
    }
    public Page<Post> findByIds(List<Long> postIds,String sortKeyWord,PageRequest req)
    {
        Page<Post> post;
        if(sortKeyWord!="empty")
        {
            if(sortKeyWord.equals("crAsc"))
                post= repo.findByIdsCAsc(postIds,req);
            else if(sortKeyWord.equals("crDesc"))
                post= repo.findByIdsCDesc(postIds,req);
            else if(sortKeyWord.equals("upAsc"))
                post= repo.findByIdsUAsc(postIds,req);
            else
                post= repo.findByIdsUDesc(postIds,req);
            System.out.println("Sort res:"+post);
        }
        else {
            post=repo.findByIdsCAsc(postIds,req);
        }
        return post;
    }

    public List<Long> allFilters(String name,long authId, long categId)
    {
        boolean ResultFound=true;
        System.out.println("name is:"+name);
        System.out.println("authId is:"+authId);
        System.out.println("categId is:"+categId);
        List<Post> post=findAll();
        List<Post> temp;
        if(name!="")
        {
            temp=repo.findByTitleLike("%"+name+"%");
            System.out.println("search result is:"+temp);
            if(!temp.isEmpty())
            {
                post.retainAll(temp);
            }
            else
            {
                post=repo.findByTitleLike("%"+name+"%");
            }
            if(post.isEmpty())
            {
                ResultFound=false;
            }
        }
        if(authId!=-1&&ResultFound)
        {
            temp=repo.getPostByAuthor(authId);
            if(!temp.isEmpty())
            {
                post.retainAll(temp);
            }
            if(post.isEmpty())
            {
                ResultFound=false;
            }
        }
        if(categId!=-1&&ResultFound)
        {
            temp=repo.getPostByCategory(categId);
            if(!temp.isEmpty())
            {
                post.retainAll(temp);
            }
            if(post.isEmpty())
            {
                ResultFound=false;
            }
        }
        List<Long> id=new ArrayList<>();
        for(int i=0;i<post.size();i++)
        {
            id.add(post.get(i).getId());
        }
        return id;
    }

    public long count()
    {
        return repo.count();
    }
}