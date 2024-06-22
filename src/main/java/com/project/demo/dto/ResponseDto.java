package com.project.demo.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseDto {
    private String status;
    private String message;
    
    public ResponseDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
    
}
