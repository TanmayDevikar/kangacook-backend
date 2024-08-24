package com.tanmay.kangacook_backend.repository;

import com.tanmay.kangacook_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
