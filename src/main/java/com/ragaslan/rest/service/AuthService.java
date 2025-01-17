package com.ragaslan.rest.service;

import com.ragaslan.rest.entity.User;

public interface AuthService {

    String login(User user);
    User register(User user);
}
