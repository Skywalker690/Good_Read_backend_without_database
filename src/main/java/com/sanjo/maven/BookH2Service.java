package com.sanjo.maven;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.*;

@Service
public class BookH2Service implements BookRepo{
    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Book> getBooks(){
        List<Book> books =db.query("select * from book", new BookRowMapper());
        return new ArrayList<>(books);

    }

    @Override
    public Book getBook(int bookId){

        try {
            return db.queryForObject("select * from book where id =?",new BookRowMapper(),bookId);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }

    }

    @Override
    public Book addBook(Book book){
        db.update("insert into book(name,imageurl) values(?,?)",book.getBookName(),book.getImageUrl());

        return db.queryForObject("select * from book where name=? and imageurl=?",new BookRowMapper(),book.getBookName(),book.getImageUrl());
    }

    @Override
    public Book updateBook(int bookId, Book book) {
        if(book.getBookName() !=null){
            db.update("update book set name=? where id=?",book.getBookName(),bookId);
        }
        if (book.getImageUrl() != null){
            db.update("update book set imageurl=? where id=?",book.getImageUrl(),bookId);
        }
        return getBook(bookId);
    }

    @Override
    public ArrayList<Book> deleteBook(int bookId) {
        db.update("delete from book where id=?",bookId);
        return getBooks();
    }


}
