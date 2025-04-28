package com.sanjo.maven;

public class Book {

    private int bookId;
    private String bookName;
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
