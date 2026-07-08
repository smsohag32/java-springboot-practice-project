package com.example.bookify.controller;

import com.example.bookify.entity.Comment;
import com.example.bookify.response.ApiResponse;
import com.example.bookify.response.ApiResponseBuilder;
import com.example.bookify.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<ApiResponse<Comment>> addComment (@RequestBody Comment comment){
            Comment saveData = commentService.createComments(comment);
            return ApiResponseBuilder.created(saveData, "Comment added successfully");
    }


}
