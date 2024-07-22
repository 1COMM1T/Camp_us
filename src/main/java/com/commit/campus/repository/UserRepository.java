package com.commit.campus.repository;

import com.commit.campus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);

}
