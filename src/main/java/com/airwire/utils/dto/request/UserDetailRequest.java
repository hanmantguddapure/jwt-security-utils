package com.airwire.utils.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailRequest {
    private Long userId;
    private String username;
    private String password;
    private String role;

}