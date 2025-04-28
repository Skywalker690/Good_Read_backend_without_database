package com.sanjo.maven;

import java.util.ArrayList;

public interface BookRepo {

    ArrayList<Book> getBooks();
    Book getBook(int bookId);
    ArrayList<Book> addBook(Book book);
    Book updateBook(int bookId,Book book);
    ArrayList<Book> deleteBook(int bookId);

}
