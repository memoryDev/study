package com.memory.springjwt.service;

import com.memory.springjwt.dto.JoinDTO;
import com.memory.springjwt.entity.UserEntity;
import com.memory.springjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void joinProcess(JoinDTO joinDTO) {
        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();

        Boolean isExist = userRepository.existsByUsername(username);

        if (isExist) {

            return;
        }

//        log.info("before username={}, password={}", username, password);
        UserEntity data = new UserEntity();
        data.setUsername(username);
        data.setPassword(passwordEncoder.encode(password));
//        log.info("password encode={}", passwordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }
}
