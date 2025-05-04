package com.sanjo.maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookJpaService implements BookRepo {

    @Autowired
    private BookJpaRepository bookJpaRepository;

    @Override
    public ArrayList<Book> getBooks() {
        return new ArrayList<>(bookJpaRepository.findAll());
    }

    @Override
    public Book getBook(int bookId) {
        Optional<Book> book = bookJpaRepository.findById(bookId);
        return book.orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        return bookJpaRepository.save(book);
    }

    @Override
    public Book updateBook(int bookId, Book book) {
        if (bookJpaRepository.existsById(bookId)) {
            book.setBookId(bookId);
            return bookJpaRepository.save(book);
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Book> deleteBook(int bookId) {
        if (bookJpaRepository.existsById(bookId)) {
            bookJpaRepository.deleteById(bookId);
        }
        return new ArrayList<>(bookJpaRepository.findAll());
    }
}
