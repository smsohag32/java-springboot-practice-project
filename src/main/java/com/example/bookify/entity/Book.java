package com.example.bookify.entity; // This file is inside the entity package.

import jakarta.persistence.Column; // This import helps us set rules for database columns.
import jakarta.persistence.Entity; // This import lets this class become a database entity.
import jakarta.persistence.GeneratedValue; // This import lets the id be generated automatically.
import jakarta.persistence.GenerationType; // This import selects the auto id generation type.
import jakarta.persistence.Id; // This import marks a field as the primary key.
import jakarta.persistence.Table; // This import lets us choose the database table name.
import lombok.Getter;
import lombok.Setter;

@Entity // This tells Spring Boot that Book is a database entity.
@Table(name = "books") // This tells Spring Boot to use a table named books.
@Getter
@Setter

public class Book { // This class represents one book record.

    @Id // This marks id as the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This makes MySQL create id automatically.
    private Long id; // This stores the unique id of the book.

    @Column(nullable = false) // This makes title required in the database.
    private String title; // This stores the book title.

    @Column(nullable = false) // This makes author required in the database.
    private String author; // This stores the book author.

    private String description; // This stores details about the book.

    private Double price; // This stores the book price.

}
