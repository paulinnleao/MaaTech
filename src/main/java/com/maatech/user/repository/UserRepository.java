package com.maatech.user.repository;

import com.maatech.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    UserDetails findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findUser(String email);
}
