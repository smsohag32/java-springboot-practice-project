package com.example.bookify.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BlogResponse {
    private Long id;
    private String title;
    private String description;
    private String author;
    private LocalDateTime createdAt;
    private int commentCount;
}
