package com.blog.bootapp.controller;

import com.blog.bootapp.BootappApplication;
import com.blog.bootapp.model.Category;
import com.blog.bootapp.model.User;
import com.blog.bootapp.service.CategoryService;
import com.blog.bootapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    UserService us;

    @RequestMapping("/register")
    public String register()
    {
        return "SignUp";
    }

    @Autowired
    CategoryService cs;

    private static final Logger LOGGER= LoggerFactory.getLogger(BootappApplication.class);

    @RequestMapping("/newUser")
    public String signUp(ModelMap model,
                         @RequestParam(value="username", defaultValue = "") String name,
                         @RequestParam(value="email", required=false, defaultValue = "0") String email,
                         @RequestParam(value="password", defaultValue = "") String password)
    {
        if(us.newUserName(name)) {
            User user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setRoles("ROLE_author");
            user.setActive(true);
            String hpw=new BCryptPasswordEncoder().encode(password);
            user.setPassword(hpw);
            us.save(user);
            model.addAttribute("message","Registered Successfully");
            return "message";
        }
        else
        {
            model.addAttribute("exist","username already exist");
            return "SignUp";
        }
    }
    @RequestMapping("/category")
    public String category()
    {
        return "addcategory";
    }

    @RequestMapping("/newCat")
    public String newCategory(ModelMap model,
                              @RequestParam(value="catname", defaultValue = "") String name)
    {
        if(cs.catName(name)) {
            Category cat=new Category();
            cat.setName(name);
            cs.save(cat);
            LOGGER.trace("New Category type added ,Category name:"+name);
            model.addAttribute("message","Category "+name+" added");
            return "message";
        }
        else
        {
            model.addAttribute("exist","category already exist");
            return "addcategory";
        }
    }

}
