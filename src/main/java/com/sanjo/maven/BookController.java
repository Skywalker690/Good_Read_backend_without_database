package com.sanjo.maven;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BookController {

    BookServices bookServices = new BookServices();

    @GetMapping("/books")
    public ArrayList<Book> getBooks(){
        return bookServices.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId){
        return bookServices.getBook(bookId);
    }

    @PostMapping("/books")
    public ArrayList<Book> addBook(@RequestBody Book book){
        return bookServices.addBook(book);
    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable int bookId,@RequestBody Book book){
        return bookServices.updateBook(bookId,book);
    }

    @DeleteMapping("/books/{bookId}")
    public ArrayList<Book> deleteBook(@PathVariable int bookId){
        return bookServices.deleteBook(bookId);
    }





}
