package com.example.autorentrest.repository;

import com.example.autorentrest.model.Role;
import com.example.autorentrest.model.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {


    Optional<User> findByEmail(String email);

    Page<User> findUsersById(int userId, Pageable pageable);
    Optional<User> findByEmailAndVerifyToken(String email, String token);
}
