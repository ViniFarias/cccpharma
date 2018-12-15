package com.cccpharma.user;

/**
 * Interface for service operations on a repository for the {@code User} type.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see User
 */
public interface UserService {

    /**
     * Saves a given user.
     *
     * @param user must not be {@literal null}
     * @return the saved user, it will never be {@literal null}
     */
    User save(User user);

    /**
     * Retrieves an user by its username.
     *
     * @param username must not be {@literal null}
     * @return the entity with the given username or {@literal null} if none found
     */
    User findByUsername(String username);

    /**
     * Updates the access token of the user with the given username.
     *
     * @param username must not be {@literal null}
     * @param token the new token value, must not be {@literal null}
     * @return the updated user.
     */
    User updateAccessTokenByUsername(String username, String token);
}
