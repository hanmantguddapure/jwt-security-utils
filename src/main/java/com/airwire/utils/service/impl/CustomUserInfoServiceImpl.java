package com.airwire.utils.service.impl;

import com.airwire.utils.dto.request.UserDetailRequest;
import com.airwire.utils.entity.Role;
import com.airwire.utils.entity.User;
import com.airwire.utils.repository.RoleRepository;
import com.airwire.utils.repository.UserRepository;
import com.airwire.utils.service.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserInfoServiceImpl implements CustomUserDetailService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetailRequest saveUserDetails(UserDetailRequest userDetails) {
       Role role =roleRepository.getRoleById(1l);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        String hashedPassword = passwordEncoder.encode(userDetails.getPassword());
        userRepository.save(User.builder().userId(userDetails.getUserId()).username(userDetails.getUsername()).
                password(hashedPassword).roles(roles).build());
        return userDetails;
    }
}
