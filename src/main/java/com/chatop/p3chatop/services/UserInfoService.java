package com.chatop.p3chatop.services;

import com.chatop.p3chatop.dto.MeResponseDTO;
import com.chatop.p3chatop.entities.User;
import com.chatop.p3chatop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    private final UserRepository userRepository;

    public UserInfoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MeResponseDTO getUser(String email) {

        User user = userRepository.findByEmail(email).orElseThrow();

        MeResponseDTO meResponseDTO = new MeResponseDTO();
        meResponseDTO.setId(user.getId());
        meResponseDTO.setName(user.getName());
        meResponseDTO.setEmail(email);
        meResponseDTO.setCreated_at(user.getCreatedAt());
        meResponseDTO.setUpdated_at(user.getUpdatedAt());

        return meResponseDTO;
    }
}
