package com.chatop.p3chatop.services;

import com.chatop.p3chatop.entities.User;
import com.chatop.p3chatop.exceptions.ResourceNotFoundException;
import com.chatop.p3chatop.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserIdService {

    private final UserRepository userRepository;

    public UserIdService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer getId() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return user.getId();
    }
}
