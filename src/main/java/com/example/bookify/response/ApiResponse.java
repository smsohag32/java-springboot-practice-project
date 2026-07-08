package com.example.bookify.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private boolean success;

    private int status;

    private String message;

    private T data;

    private Object errors;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}