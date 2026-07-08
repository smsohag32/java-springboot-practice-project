package com.example.bookify.service;

import com.example.bookify.dto.BlogRequest;
import com.example.bookify.dto.BlogResponse;
import com.example.bookify.entity.Blog;
import com.example.bookify.repositories.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogResponse createBlog(BlogRequest request) {
        Blog blog = new Blog();
        blog.setTitle(request.getTitle());
        blog.setDescription(request.getDescription());
        blog.setAuthor(request.getAuthor());
        blog.setCreatedAt(LocalDateTime.now());

        return mapToResponse(blogRepository.save(blog));
    }

    public BlogResponse updateBlog(BlogRequest request, Long id) {
        Blog blog = findBlogById(id);

        blog.setAuthor(request.getAuthor());
        blog.setDescription(request.getDescription());
        blog.setTitle(request.getTitle());

        return mapToResponse(blogRepository.save(blog));
    }

    public BlogResponse getBlogById(Long id) {
        return mapToResponse(findBlogById(id));
    }

    public List<BlogResponse> getAllBlogs() {
        return blogRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"))
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public String deleteBlog(Long id) {
        Blog blog = findBlogById(id);
        blogRepository.delete(blog);
        return "Deleted Successfully";
    }

    private Blog findBlogById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Blog not found with id: " + id));
    }

    private BlogResponse mapToResponse(Blog blog) {
        int commentCount = blog.getComments() == null ? 0 : blog.getComments().size();

        return BlogResponse.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .description(blog.getDescription())
                .author(blog.getAuthor())
                .createdAt(blog.getCreatedAt())
                .commentCount(commentCount)
                .build();
    }
}
