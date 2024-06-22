package com.project.demo.common;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiResponse {
    private final boolean succes;
    private final String message;

    public ApiResponse(boolean succes, String message) {
        this.succes = succes;
        this.message = message;
    }

    public String getTimestamp() {
		return LocalDateTime.now().toString();
	}
    
}
