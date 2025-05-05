package com.sanjo.maven.repository;

import com.sanjo.maven.model.Book;

import java.util.ArrayList;

public interface BookRepo {

    ArrayList<Book> getBooks();
    Book getBook(int bookId);
    Book addBook(Book book);
    Book updateBook(int bookId,Book book);
    ArrayList<Book> deleteBook(int bookId);


}
