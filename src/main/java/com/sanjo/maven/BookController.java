package com.sanjo.maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookJpaService bookServices;

    @GetMapping
    public List<Book> getBooks() {
        return bookServices.getBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable int bookId) {
        return bookServices.getBook(bookId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookServices.addBook(book);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable int bookId, @RequestBody Book book) {
        return bookServices.updateBook(bookId, book);
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int bookId) {
        bookServices.deleteBook(bookId);
    }
}