package com.ragaslan.rest.service.impl;

import com.ragaslan.rest.dao.UserDAO;
import com.ragaslan.rest.entity.User;
import com.ragaslan.rest.entity.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {


    private final UserDAO userDAO;

    @Autowired
    public MyUserDetailsServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user = userDAO.findByUsername(username);

         if(user == null){
             System.out.println("User not found");
             throw new UsernameNotFoundException("user not found !");
         }

         return new UserPrincipal(user);
    }
}
