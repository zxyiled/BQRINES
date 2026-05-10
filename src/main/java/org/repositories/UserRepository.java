package org.repositories;

import org.models.User;
import java.util.Optional;

public class UserRepository {

    // Authentication on Spring Security
    Optional<User> findByEmail(String email);

    // Check if a user exists by email (used for registration validation)
    boolean existsByEmail(String email);
}
