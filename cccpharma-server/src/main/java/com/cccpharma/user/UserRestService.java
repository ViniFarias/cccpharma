package com.cccpharma.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserRestService {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public User registration(@RequestBody User user) {
        User savedUser = userService.save(user);

        return savedUser;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody  User user) {
        return "OK";
    }
}
