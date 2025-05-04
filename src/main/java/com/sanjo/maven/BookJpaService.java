package com.sanjo.maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return bookJpaRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + bookId + " not found"));
    }

    @Override
    public Book addBook(Book book) {
        if (book == null || book.getBookName() == null || book.getBookName().isEmpty()) {
            throw new IllegalArgumentException("Book name is required");
        }
        return bookJpaRepository.save(book);
    }

    @Override
    public Book updateBook(int bookId, Book updatedBook) {
        Book existingBook = bookJpaRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + bookId + " not found"));
        existingBook.setBookName(updatedBook.getBookName());
        existingBook.setImageUrl(updatedBook.getImageUrl());
        return bookJpaRepository.save(existingBook);
    }

    @Override
    public ArrayList<Book> deleteBook(int bookId) {
        if (!bookJpaRepository.existsById(bookId)) {
            throw new BookNotFoundException("Book with ID " + bookId + " not found");
        }
        bookJpaRepository.deleteById(bookId);
        return (ArrayList<Book>) bookJpaRepository.findAll();
    }
}

// Custom exception
class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}