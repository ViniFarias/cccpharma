package com.cccpharma.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The {@Code UserRestService} class is the web controller for user operations.
 * It can be accessed by {@code '/users'} endpoint.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 */
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserRestService {

    /**
     * The user operations service.
     */
    @Autowired
    private UserService userService;

    /**
     * Register a given user.
     * It can be accessed by a POST request to the {@code '/users/registration'} endpoint,
     * passing an user in the request body.
     *
     * @param user must not be {@literal null}
     * @return the saved user, it will never be {@literal null}
     */
    @PostMapping(value = "/registration")
    public User registration(@RequestBody User user) {
        User savedUser = userService.save(user);

        return savedUser;
    }
}
