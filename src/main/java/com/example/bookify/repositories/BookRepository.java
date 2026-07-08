package com.example.bookify.repositories; // This file is inside the repositories package.

import com.example.bookify.entity.Book; // This imports the Book entity class.
import org.springframework.data.jpa.repository.JpaRepository; // This gives ready-made database methods like save, findAll, and findById.

public interface BookRepository extends JpaRepository<Book, Long> {
    // This repository works with Book entity and Long id.
}
