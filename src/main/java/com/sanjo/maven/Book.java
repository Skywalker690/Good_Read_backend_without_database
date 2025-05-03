package com.sanjo.maven;
import jakarta.persistence.*;

@Entity
@Table(schema = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(name = "name")
    private String bookName;

    @Column(name = "imageurl")
    private String imageUrl;

    Book(int bookId,String bookName,String imageUrl){
        this.bookId=bookId;
        this.imageUrl=imageUrl;
        this.bookName=bookName;
    }

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



}
