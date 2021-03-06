package com.blog.bootapp.controller;
import java.util.ArrayList;

import com.blog.bootapp.MyUserDetailService;
import com.blog.bootapp.model.Category;
import com.blog.bootapp.model.Post;
import com.blog.bootapp.model.User;
import com.blog.bootapp.service.CategoryService;
import com.blog.bootapp.service.PostService;
import com.blog.bootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private PostService ps;
    @Autowired
    private CategoryService cs;
    @Autowired
    private UserService us;
    @Autowired
    private MyUserDetailService ms;
    private long updateID;
    private int PAGE_SIZE =3;
    private long totalPostsCount;
    private String currentUserName;
    private long author_id;

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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
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
    @RequestMapping({"/addPost"})
    public String addPost(Model model) {
        Post post = new Post();
        List<Category> categoryList=cs.listAll();
        post.setCategoryList(categoryList);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUserName= authentication.getName();
        List<User> userList = us.listAll();
        author_id=ps.authorId(userList,currentUserName);
        post.setAuthorId(author_id);
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUserName= authentication.getName();
        List<User> userList = us.listAll();
        author_id=ps.authorId(userList,currentUserName);
        post.setAuthorId(author_id);
        post.setTitle(post.getTitle());
        ps.save(post);
        return "message";
    }

    @RequestMapping({"/read/{id}","/page/read/{id}"})
    public String openContent(@PathVariable("id") long id, ModelMap model)
    {
        Post p = ps.get(id);
            model.addAttribute("post", p);
        return "content";
    }

    @RequestMapping({"read/edit/{id}","page/read/edit/{id}"})
    public String editContent(@PathVariable("id") long id, ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       currentUserName= authentication.getName();
       List<User> userList = us.listAll();
       author_id=ps.authorId(userList,currentUserName);
        Post post = ps.get(id);
        if(post.getAuthorId()==author_id||authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_admin"))) {
            updateID = id;
            model.addAttribute("post", post);
            model.addAttribute("id", post.getId());
            model.addAttribute("title", post.getTitle());
            model.addAttribute("author_id", post.getAuthorId());
            model.addAttribute("categoryList", post.getCategoryList());
            model.addAttribute("content", post.getContent());
            model.addAttribute("heading", "UPDATE");
            model.addAttribute("formAction", "updatePost");
            return "create";
        }
        else
        {
            model.addAttribute("message","you aren't authorized to edit or delete this post");
            return "message";
        }

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
        return "message";
    }


    @RequestMapping({"read/delete/delete/{id}","page/read/delete/delete/{id}"})
    public String deleteContent(@PathVariable("id") long id,Model model) {
            ps.delete(id);
        model.addAttribute("message", "Deleted Successfully");
        return "message";
    }


    @RequestMapping({"read/delete/{id}","page/read/delete/{id}"})
    public String confirmDelete(@PathVariable("id") long id, ModelMap model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        currentUserName= authentication.getName();
        List<User> userList = us.listAll();
        author_id=ps.authorId(userList,currentUserName);
        Post post = ps.get(id);
        if(post.getAuthorId()==author_id||authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_admin"))) {
            model.addAttribute("id", id);
            return "confirmDelete";
        }
        else
        {
            model.addAttribute("message","you aren't authorized to edit or delete this post");
            return "message";
        }
    }
}