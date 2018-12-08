package com.cccpharma.service;

import com.cccpharma.domain.orm.User;

public interface UserService {

    User save(User user);
    User findByUsername(String username);
    User updateAccessTokenByUsername(String username, String token);
}
