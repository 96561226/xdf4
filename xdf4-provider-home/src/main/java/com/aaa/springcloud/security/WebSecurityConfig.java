package com.aaa.springcloud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity//启动安全框架
@EnableGlobalMethodSecurity(prePostEnabled = true)//开发方法注解控制
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    CustomerUserDetailService customerUserDetailService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     auth.userDetailsService(customerUserDetailService).passwordEncoder(new PasswordEncoder() {
         @Override
         public String encode(CharSequence charSequence) {
             return passwordEncoder().encode(charSequence);
         }

         @Override
         public boolean matches(CharSequence charSequence, String s) {
             return passwordEncoder().matches(charSequence,s);
         }
     });

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();//允许使用框架
        //放行登录界面
        http.authorizeRequests()
                .antMatchers("/userLogin")
                .permitAll()
//                .antMatchers("/books/**").hasAnyRole("admin","图书管理")
//                .antMatchers("/persons/**").hasAnyRole("人事经理")
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin().loginPage("/userLogin").defaultSuccessUrl("/toHome").failureForwardUrl("/myError")
                .and()
                .csrf().disable();

    }
    //放行静态资源
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**").antMatchers("/static/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
