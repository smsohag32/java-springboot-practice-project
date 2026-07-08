package com.example.bookify.repositories;

import com.example.bookify.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {


}
