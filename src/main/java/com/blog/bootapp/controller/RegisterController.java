package com.blog.bootapp.controller;

import com.blog.bootapp.model.User;
import com.blog.bootapp.service.UserService;
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
            return "signUpMessage";
        }
        else
        {
            model.addAttribute("exist","username already exist");
            return "SignUp";
        }
    }
}
