package com.sanjo.maven;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(name = "name")
    private String bookName;

    @Column(name = "imageurl")
    private String imageUrl;

    // Required by JPA
    public Book() {
    }

    public Book(int bookId, String bookName, String imageUrl) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.imageUrl = imageUrl;
    }

    // Getters and setters (unchanged)


    public void setBookId(int bookId){
        this.bookId=bookId;
    }

    public void setBookName(String bookName){
        this.bookName=bookName;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl=imageUrl;
    }

    public int getBookId(){
        return this.bookId;
    }

    public String  getBookName(){
        return this.bookName;
    }

    public String getImageUrl(){
        return this.imageUrl;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(imageUrl, book.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookName, imageUrl);
    }
}





