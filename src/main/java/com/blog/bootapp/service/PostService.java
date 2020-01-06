package com.blog.bootapp.service;

import com.blog.bootapp.controller.HomeController;
import com.blog.bootapp.model.User;
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
        Post post=repo.getById(id);
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
        }
        else {
            post=repo.findByIdsCAsc(postIds,req);
        }
        return post;
    }

    public List<Long> allFilters(String name,long authId, long categId)
    {
        boolean ResultFound=true;
        List<Post> post=findAll();
        List<Post> temp;
        if(name!="")
        {
            temp=repo.findByTitleLike("%"+name+"%");
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


    public long authorId(List<User> userList,String UserName)
    {
        for(int i=0;i<userList.size();i++)
        {
            if(UserName.equals(userList.get(i).getName()))
            {
                return userList.get(i).getUserId();
            }
        }
        return 0;
    }

    public String authorName(List<User> userList,long id)
    {
        String name=null;
        for(int i=0;i<userList.size();i++)
        {
            if(id==(userList.get(i).getUserId()))
            {
                name=userList.get(i).getName();
            }
        }
        return name;
    }

    public  boolean isPostExist(long id)
    {
        return repo.existsById(id);
    }
}