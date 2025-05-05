package com.sanjo.maven.service;

import com.sanjo.maven.model.Book;
import com.sanjo.maven.repository.BookJpaRepository;
import com.sanjo.maven.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class BookJpaService implements BookRepo {

    @Autowired
    private BookJpaRepository bookJpaRepository;

    @Override
    public ArrayList<Book> getBooks() {
        return (ArrayList<Book>) bookJpaRepository.findAll();
    }

    @Override
    public Book getBook(int bookId) {
        try {
            return  bookJpaRepository.findById(bookId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
    }

    @Override
    public Book addBook(Book book) {
        bookJpaRepository.save(book);
        return book;

    }

    public Book updateBook(int bookId, Book updatedBook) {


        Book existingBook = getBook(bookId);
        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }

        if (updatedBook.getBookName() != null) {
            existingBook.setBookName(updatedBook.getBookName());
        }

        if (updatedBook.getImageUrl() != null) {
            existingBook.setImageUrl(updatedBook.getImageUrl());
        }

        return bookJpaRepository.save(existingBook);
    }


    @Override
    public ArrayList<Book> deleteBook(int bookId) {

        Book book = getBook(bookId);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        bookJpaRepository.deleteById(bookId);
        return getBooks();

    }
}

