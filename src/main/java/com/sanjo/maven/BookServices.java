package com.sanjo.maven;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class BookServices implements BookRepo{

    HashMap<Integer,Book> map = new HashMap<>();
    int UniqueId = 3;

    BookServices(){

        Book b1 = new Book(1,"Rise of the King","king.png");
        Book b2 = new Book(2,"Rise of the Queen","queen.png");

        map.put(b1.getBookId(),b1);
        map.put(b2.getBookId(),b2);
    }

    @Override
    public ArrayList<Book> getBooks(){
        Collection<Book> bookCollection =map.values();
        return new ArrayList<>(bookCollection);
    }

    @Override
    public Book getBook(int bookId){
        Book requiredBook =map.get(bookId);
        if(requiredBook == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        else {
            return requiredBook;
        }
    }

    @Override
    public ArrayList<Book> addBook(Book book){
        book.setBookId(UniqueId);
        map.put(UniqueId,book);
        UniqueId++;
        return new ArrayList<>(map.values());

    }

    @Override
    public Book updateBook(int bookId,Book book){

        Book existingBook =map.get(bookId);

        if(existingBook == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        else {
            if(book.getBookName() != null){
                existingBook.setBookName(book.getBookName());
            }

            if(book.getImageUrl() != null){
                existingBook.setImageUrl(book.getImageUrl());
            }
        }
        return existingBook;
    }

    @Override
    public ArrayList<Book> deleteBook(int bookId){
        if(map.get(bookId)==null) throw new  ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        map.remove(bookId);
        return new ArrayList<>(map.values());
    }



}
