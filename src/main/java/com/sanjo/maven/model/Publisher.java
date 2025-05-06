package com.sanjo.maven.model;

import com.sanjo.maven.model.Book;
import com.sanjo.maven.model.Publisher;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisherid")
    private int publisherId;

    @Column(name = "publishername")
    private String publisherName;

    public Publisher(){}

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

}
