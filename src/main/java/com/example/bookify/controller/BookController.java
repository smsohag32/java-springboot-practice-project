package com.example.bookify.controller; // This file is inside the controller package.

import com.example.bookify.entity.Book; // This imports the Book entity class.
import com.example.bookify.service.BookService; // This imports the service that contains book logic.
import org.springframework.http.HttpStatus; // This import gives HTTP status names like CREATED.
import org.springframework.http.ResponseEntity; // This import lets us return status code with response data.
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // This tells Spring this class will handle REST API requests.
@RequestMapping("/book") // This sets the base API path to /api/v1/book.
public class BookController { // This class handles book API routes.

    private final BookService bookService; // This variable stores the BookService object.

    public BookController(BookService bookService) { // Spring gives BookService through this constructor.
        this.bookService = bookService; // This saves the service object for later use.
    }

    @GetMapping
    public  ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return  ResponseEntity.ok(books);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById (@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);

    }


    @PutMapping("/{id}")
    public  ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updateBook = bookService.updateBook(book, id);
        return  ResponseEntity.ok(updateBook);

    }


    @PostMapping // This makes the method handle POST /api/v1/book.
    public ResponseEntity<?> createBook(@RequestBody Book book) { // This method receives book JSON from the request body.
        Book createdBook = bookService.createBook(book); // This sends the book to service for saving.
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook); // This returns status 201 with the saved book.
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteBook (@PathVariable Long id) {
            String deleteResponse = bookService.deleteBook(id);
            return  ResponseEntity.ok(deleteResponse);

    }

}
