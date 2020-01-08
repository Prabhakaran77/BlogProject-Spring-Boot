package com.blog.bootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
//        super.configure(auth);
        auth.userDetailsService(userDetailsService);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//               .antMatchers("/**").permitAll()
////                .antMatchers("/signup").permitAll()
////                .antMatchers("/signUpMessage").permitAll()
////                .antMatchers("/post").hasAnyRole("author","admin")
////                .antMatchers("/addPost").hasAnyRole("author","admin")
////                .antMatchers("/create").hasAnyRole("author","admin")
////                .antMatchers("/read/edit/*").hasAnyRole("author","admin")
//                .and().formLogin();
////                .loginPage("/login")
////                .permitAll()
////                .defaultSuccessUrl("/")
////                .failureUrl("/login?error=true")
////                .usernameParameter("name")
////                .passwordParameter("password");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                 http.authorizeRequests()
//                .antMatchers("read/edit//*").hasRole("admin")
//                .antMatchers("read/delete/*").hasRole("admin")
//                .antMatchers("/addPost").hasAnyRole("admin","author")
                .antMatchers("/").permitAll()
                .antMatchers("/addPost/*").hasAnyRole("admin","author")
                 .antMatchers("/read/edit/*").hasAnyRole("admin","author")
                 .antMatchers("/read/delete/*").hasAnyRole("admin","author")
                .antMatchers(HttpMethod.POST).permitAll()
                         .and().formLogin().loginPage("/login").permitAll()
                         .and().logout().permitAll();

        http.csrf().disable();
//                .loginPage("/user-login").permitAll()
//                .defaultSuccessUrl("/index")
//                .failureUrl("/user-login?error=true")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .and().logout().permitAll();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
