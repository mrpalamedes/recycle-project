package com.project.demo.dto.user;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SignInResponseDto {
    private String status;
    
    private String token;

    public SignInResponseDto(String status, String token) {
        this.status = status;
        this.token = token;
    }

}
