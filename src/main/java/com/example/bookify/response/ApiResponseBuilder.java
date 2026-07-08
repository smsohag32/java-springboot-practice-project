package com.example.bookify.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseBuilder {

    private ApiResponseBuilder() {}

    public static <T> ResponseEntity<ApiResponse<T>> success(
            T data,
            String message
    ) {

        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.ok(response);
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(
            T data,
            String message
    ) {

        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(true)
                .status(HttpStatus.CREATED.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    public static ResponseEntity<ApiResponse<Object>> error(
            HttpStatus status,
            String message,
            Object errors
    ) {

        ApiResponse<Object> response = ApiResponse.builder()
                .success(false)
                .status(status.value())
                .message(message)
                .errors(errors)
                .build();

        return ResponseEntity.status(status)
                .body(response);
    }
}