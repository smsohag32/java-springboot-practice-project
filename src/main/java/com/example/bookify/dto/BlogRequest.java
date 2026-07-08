package com.example.bookify.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogRequest {
    private String title;
    private String description;
    private String author;
}
