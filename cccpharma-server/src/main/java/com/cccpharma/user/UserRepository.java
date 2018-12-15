package com.cccpharma.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for CRUD operations on a repository for the {@code User} type.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Retrieves an user by its username.
     *
     * @param username must not be {@literal null}
     * @return the entity with the given id or {@literal null} if none found
     */
    User findByUsername(String username);
}
