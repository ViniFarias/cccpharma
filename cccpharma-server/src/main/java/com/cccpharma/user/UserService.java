package com.cccpharma.user;

public interface UserService {

    User save(User user);
    User findByUsername(String username);
    User updateAccessTokenByUsername(String username, String token);
}
