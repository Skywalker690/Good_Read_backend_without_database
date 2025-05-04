package com.sanjo.maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BookController {

    @Autowired
    public BookJpaService bookServices;
    //public BookH2Service bookServices;
    @GetMapping("/books")
    public ArrayList<Book> getBooks(){
        return bookServices.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId){
        return bookServices.getBook(bookId);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){

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
