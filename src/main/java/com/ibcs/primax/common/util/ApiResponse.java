package com.ibcs.primax.common.util;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse {

    private final boolean success;
    private final String message;


    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public String getTimestamp() {
        return LocalDateTime.now().toString();
    }
}
