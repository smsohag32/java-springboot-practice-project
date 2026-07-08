package com.example.bookify.controller;

import com.example.bookify.dto.BlogRequest;
import com.example.bookify.dto.BlogResponse;
import com.example.bookify.response.ApiResponse;
import com.example.bookify.response.ApiResponseBuilder;
import com.example.bookify.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog")
@Slf4j
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<BlogResponse>>> getAllBlogs() {
        List<BlogResponse> allBlogs = blogService.getAllBlogs();
        return ApiResponseBuilder.success(allBlogs, "Blogs fetched successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BlogResponse>> getBlogById(@PathVariable Long id) {
        BlogResponse blog = blogService.getBlogById(id);
        return ApiResponseBuilder.success(blog, "Blog fetched successfully");
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BlogResponse>> createBlog(@RequestBody BlogRequest request) {
        BlogResponse createdBlog = blogService.createBlog(request);
        return ApiResponseBuilder.success(createdBlog, "Blog created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BlogResponse>> updateBlog(@RequestBody BlogRequest request, @PathVariable Long id) {
        BlogResponse updatedBlog = blogService.updateBlog(request, id);
        return ApiResponseBuilder.success(updatedBlog, "Blog updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteBlog(@PathVariable Long id) {
        String message = blogService.deleteBlog(id);
        log.info(message);
        return ApiResponseBuilder.success(message, "Blog deleted successfully");
    }
}
