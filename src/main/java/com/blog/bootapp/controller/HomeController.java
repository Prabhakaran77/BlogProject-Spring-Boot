package com.blog.bootapp.controller;
import java.util.ArrayList;

import com.blog.bootapp.model.Category;
import com.blog.bootapp.model.Post;
import com.blog.bootapp.model.User;
import com.blog.bootapp.service.CategoryService;
import com.blog.bootapp.service.PostService;
import com.blog.bootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService ps;
    @Autowired
    private CategoryService cs;
    @Autowired
    private UserService us;
    private long updateID;
    private long author_id=1;
    private int PAGE_SIZE =3;
    private long totalPostsCount;

    private PageRequest gotoPage(int page)
    {
        PageRequest request = PageRequest.of(page,PAGE_SIZE);
        return request;
    }

    @RequestMapping("/")
    public String firstRequest(Model model,@RequestParam(value="pageNo", required=false, defaultValue = "0") String pageNo) {
        int lastPageNo;
        int gotoPageNo=Integer.parseInt(pageNo);
        List<Post> post=new ArrayList<>();
        for(Post p:ps.find(gotoPage(gotoPageNo)))
        {
            post.add(p);
        }
        post.forEach(p-> {
            if (p.getContent().length() >= 300) {
                p.setContent(p.getContent().substring(0, 300) + "....");
            }
        });
        totalPostsCount=ps.count();
        if(totalPostsCount%PAGE_SIZE!=0)
            lastPageNo=(int)(totalPostsCount/PAGE_SIZE)+1;
        else
            lastPageNo=(int)(totalPostsCount/PAGE_SIZE);
        Post post1=new Post();
        List<Category> categoryList=cs.listAll();
        post1.setCategoryList(categoryList);
        List<User> userList=us.listAll();
        model.addAttribute("al",userList);
        model.addAttribute("catList",post1.getCategoryList());
        model.addAttribute("lastPageNo",lastPageNo);
        model.addAttribute("lists",post);
        return "index";
    }

        @RequestMapping("/post")
    public String allFilter(ModelMap model,
                            @RequestParam(value="name", defaultValue = "") String name,
                            @RequestParam(value="pageNo", required=false, defaultValue = "0") String pageNo,
                            @RequestParam(value="sort-by", defaultValue = "") String sortKeyWord,
                            @RequestParam(value="filter-by-auth", defaultValue = "-1") long authId,
                             @RequestParam(value="filter-by-cat", defaultValue = "-1") long categId)
    {
        int lastPageNo;
        int gotoPageNo=Integer.parseInt(pageNo);
        List<Long> postIds=ps.allFilters(name,authId,categId);
        totalPostsCount=postIds.size();
        List<Post> post=null;
        if(totalPostsCount>0) {
             post = ps.findByIds(postIds, sortKeyWord, gotoPage(gotoPageNo)).getContent();
            post.forEach(p-> {
                if (p.getContent().length() >= 300) {
                    p.setContent(p.getContent().substring(0, 300) + "....");
                }
            });
        }
        if(totalPostsCount%PAGE_SIZE!=0)
            lastPageNo=(int)(totalPostsCount/PAGE_SIZE)+1;
        else
            lastPageNo=(int)(totalPostsCount/PAGE_SIZE);
        Post post1=new Post();
        List<Category> categoryList=cs.listAll();
        post1.setCategoryList(categoryList);
        List<User> userList=us.listAll();
        model.addAttribute("presName",name);
        model.addAttribute("presSortBy",sortKeyWord);
        model.addAttribute("presAuthId",authId);
        model.addAttribute("presCatId",categId);
        model.addAttribute("al",userList);
        model.addAttribute("catList",post1.getCategoryList());
        model.addAttribute("filterPageNo",lastPageNo);
        model.addAttribute("lists",post);
        return "index";
    }
    @RequestMapping({"/addPost","/**/addPost"})
    public String addPost(Model model) {
        Post post = new Post();
        List<Category> categoryList=cs.listAll();
        post.setCategoryList(categoryList);
        post.setAuthorId(author_id);
        System.out.println("category list is:"+categoryList);
        model.addAttribute("post", post);
        model.addAttribute("categoryList",post.getCategoryList());
        model.addAttribute("users_author_id",post.getAuthorId());
        model.addAttribute("id", post.getId());
        model.addAttribute("title", post.getTitle());
        model.addAttribute("content", post.getContent());
        model.addAttribute("heading", "CREATE");
        model.addAttribute("formAction", "create");
        return "create";
    }

    @RequestMapping("/create")
    public String updatePost(@ModelAttribute("post") Post post, ModelMap model) {
        model.addAttribute("message", "Creation successfull");
        post.setAuthorId(author_id);
        post.setTitle(post.getTitle());
        ps.save(post);
        return "addMessage";
    }

    @RequestMapping({"/read/{id}","/page/read/{id}"})
    public String openContent(@PathVariable("id") long id, ModelMap model) {
            System.out.println("checking program control");
        Post p = ps.get(id);
        model.addAttribute("post", p);
        System.out.println("b4 return");
        return "content";
    }

    @RequestMapping({"read/edit/{id}","page/read/edit/{id}"})
    public String editContent(@PathVariable("id") long id, ModelMap model) {
        Post post = ps.get(id);
        updateID=id;
        model.addAttribute("post", post);
        model.addAttribute("id", post.getId());
        model.addAttribute("title", post.getTitle());
        model.addAttribute("author_id",post.getAuthorId());
        model.addAttribute("categoryList",post.getCategoryList());
        model.addAttribute("content", post.getContent());
        model.addAttribute("heading", "UPDATE");
        model.addAttribute("formAction", "updatePost");
        return "create";
    }

    @RequestMapping({"read/edit/updatePost","page/read/edit/updatePost"})
    public String update(@ModelAttribute("post") Post post, ModelMap model) {
        post.setId(updateID);
        post.setAuthorId(post.getAuthorId());
        post.setCategoryList(post.getCategoryList());
        post.setContent(post.getContent());
        post.setTitle(post.getTitle());
        ps.save(post);
       model.addAttribute("message", "Updated Successfully");
        return "updateMessage";
    }


    @RequestMapping({"read/delete/delete/{id}","page/read/delete/delete/{id}"})
    public String deleteContent(@PathVariable("id") long id) {
            System.out.println("b4 calling delete method");
            ps.delete(id);
        System.out.println("after calling delete method");
        return "del";
    }

    @RequestMapping({"read/delete/{id}","page/read/delete/{id}"})
    public String confirmDelete(@PathVariable("id") long id, ModelMap model)
    {
        model.addAttribute("id",id);
        return "confirmDelete";
    }

}