package com.cccpharma.user;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The {@code User} class represents an user.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 */
@Entity
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * The user identifier.
     * It's generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The username used to sign in to the system.
     * It is unique for each user.
     */
    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String username;

    /**
     * The password used to sign in to the system.
     */
    @NotNull
    @NotEmpty
    private String password;

    /**
     * The user's full name.
     */
    @NotNull
    @NotEmpty
    private String name;

    /**
     * A Boolean value that indicates whether the user is an administrator or not.
     */
    @NotNull
    @NotEmpty
    private boolean admin;

    /**
     * A token that gives the user authorization to use the system.
     * It's updated whenever the user logs in to the system.
     */
    private String accessToken;
}
