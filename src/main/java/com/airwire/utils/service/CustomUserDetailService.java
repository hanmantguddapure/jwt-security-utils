package com.airwire.utils.service;

import com.airwire.utils.dto.request.UserDetailRequest;

public interface CustomUserDetailService {
    UserDetailRequest saveUserDetails(UserDetailRequest userDetails);
}
