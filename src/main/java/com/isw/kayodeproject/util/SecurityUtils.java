package com.isw.kayodeproject.util;

import com.isw.kayodeproject.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class SecurityUtils {

    public static User getCurrentUser(){
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principle instanceof Users){
            return (User) principle;
        }
        return null;
    }

    public static String getRole(){
        User user = getCurrentUser();
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        for(GrantedAuthority authority: authorities){
            return authority.getAuthority();
        }
        return null;
    }
}
