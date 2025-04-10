package com.airwire.utils.service.impl;

import com.airwire.utils.dto.request.UserDetailRequest;
import com.airwire.utils.entity.User;
import com.airwire.utils.repository.UserRepository;
import com.airwire.utils.service.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserInfoServiceImpl implements CustomUserDetailService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetailRequest saveUserDetails(UserDetailRequest userDetails) {
        String hashedPassword = passwordEncoder.encode(userDetails.getPassword());
        userRepository.save(User.builder().userId(userDetails.getUserId()).username(userDetails.getUsername()).
                password(hashedPassword).roles(userDetails.getRole()).build());
        return userDetails;
    }
}
