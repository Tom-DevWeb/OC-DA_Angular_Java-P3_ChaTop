package com.chatop.p3chatop.services;

import com.chatop.p3chatop.dto.MeResponseDTO;
import com.chatop.p3chatop.entities.User;
import com.chatop.p3chatop.exceptions.ResourceNotFoundException;
import com.chatop.p3chatop.mappers.UserMapper;
import com.chatop.p3chatop.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserInfoService(
            UserRepository userRepository,
            UserMapper userMapper
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public MeResponseDTO getUser(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return userMapper.toUserDTO(user);
    }

    public MeResponseDTO getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return userMapper.toUserDTO(user);

    }
}
