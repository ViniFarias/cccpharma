package com.cccpharma.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * The {@code UserServiceImpl} class implements the {@code UserService} methods with the business rule.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see UserService
 */
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    /**
     * The interface for operations on the user repository.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Saves a given user.
     * Encrypt the user's password and configures the user as non-administrator before saving.
     *
     * @param user must not be {@literal null}
     * @return the saved user, it will never be {@literal null}
     */
    @Override
    public User save(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setAdmin(false);
        return userRepository.save(user);
    }

    /**
     * Retrieves an user by its username.
     *
     * @param username must not be {@literal null}
     * @return the entity with the given id or {@literal null} if none found
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Updates the access token of the user with the given username.
     *
     * @param username must not be {@literal null}
     * @param token the new token value, must not be {@literal null}
     * @return the updated user.
     */
    @Override
    public User updateAccessTokenByUsername(String username, String token) {
        User user = findByUsername(username);
        user.setAccessToken(token);

        return userRepository.save(user);
    }
}
