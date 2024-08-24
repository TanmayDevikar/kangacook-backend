package com.tanmay.kangacook_backend.service;

import com.tanmay.kangacook_backend.model.User;
import com.tanmay.kangacook_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveNewUser(User user) {
        userRepository.save(user);
    }

    public User loginUser(User user) {
        Optional<User> useDB = userRepository.findById(user.getId());
        return useDB.orElse(null);
    }
}
