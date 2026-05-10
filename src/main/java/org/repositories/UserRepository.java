package org.repositories;

import org.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Authentication on Spring Security
    Optional<User> findByEmail(String email);

    // Check if a user exists by email (used for registration validation)
    boolean existsByEmail(String email);
}
