package com.ragaslan.rest.service.impl;

import com.ragaslan.rest.dao.UserDAO;
import com.ragaslan.rest.entity.User;
import com.ragaslan.rest.service.AuthService;
import com.ragaslan.rest.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {


    private final UserDAO userDAO;

    private final BCryptPasswordEncoder encoder;

    private final JWTService jwtService;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthServiceImpl(UserDAO userDAO,JWTService jwtService,AuthenticationManager authenticationManager){
        this.userDAO = userDAO;
        this.encoder = new BCryptPasswordEncoder(12);
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }



    @Override
    public String login(User user) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }else{
            return "fail";
        }
    }

    @Override
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDAO.save(user);
        return user;
    }

}
