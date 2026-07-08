package com.example.bookify.service; // This file is inside the service package.

import com.example.bookify.entity.Book; // This imports the Book entity class.
import com.example.bookify.repositories.BookRepository; // This imports the repository that talks to the database.
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service; // This import lets Spring know this class is a service.

import java.util.List;

@Service // Spring will automatically create an object of this service class.
@RequiredArgsConstructor

public class BookService { // This class contains book business logic.

    private final BookRepository bookRepository; // This variable stores the BookRepository object.



    public Book createBook(Book book) {
        // This method receives a book from the controller.
        return bookRepository.save(book); // This saves the book in the database and returns the saved book.
    }
    public Book updateBook (Book  book, Long id) {
        Book bookbyid = bookRepository.findById(id).orElseThrow(null);

        bookbyid.setAuthor(book.getAuthor());
        bookbyid.setDescription(book.getDescription());
        bookbyid.setPrice(book.getPrice());
        bookbyid.setTitle(book.getTitle());

        return bookRepository.save(bookbyid);

    }
    public  Book getBookById (Long id) {
        return bookRepository.findById(id).orElseThrow(
                null
        );
    }
    public List<Book> getAllBooks () {
        return  bookRepository.findAll();
    }
    public String deleteBook (Long id) {
        bookRepository.deleteById(id);
        return  "Deleted Successfully";
    }
}
