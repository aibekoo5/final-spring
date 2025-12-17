package com.aibek.finalspring.repository;

import com.aibek.finalspring.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String username);
}