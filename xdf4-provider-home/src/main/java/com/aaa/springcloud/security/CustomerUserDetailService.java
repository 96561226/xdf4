package com.aaa.springcloud.security;

import com.aaa.pojo.Emp;
import com.aaa.pojo.Roles;
import com.aaa.springcloud.service.api.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomerUserDetailService  implements UserDetailsService {

    @Autowired
    EmpService empService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        System.out.println("username"+username);
        Emp emp = empService.selectByNo(username);
        System.out.println("emp"+emp);
        if(null == emp){
            throw  new UsernameNotFoundException("该用户不存在!");
        }
        //找对该用户对应的角色
        Roles role = empService.selectRolesByNo(emp.getEmp_no());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole_name()));
        authorities.add(new SimpleGrantedAuthority(emp.getEmp_name()));
        authorities.add(new SimpleGrantedAuthority(emp.getEmp_no()));
        authorities.add(new SimpleGrantedAuthority(emp.getEmp_id().toString()));
        return new User(emp.getEmp_no(),emp.getPwd(),authorities);
    }

}
