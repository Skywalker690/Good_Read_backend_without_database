package com.sanjo.maven.service;

import com.sanjo.maven.repository.PublisherJpaRepository;
import com.sanjo.maven.model.Publisher;
import com.sanjo.maven.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherJpaService implements PublisherRepository {

    @Autowired
    private PublisherJpaRepository publisherJpaRepository;


    @Override
    public ArrayList<Publisher> getPublishers() {
        List<Publisher> publisherList = publisherJpaRepository.findAll();
        ArrayList<Publisher> publishers = new ArrayList<>(publisherList);
        return publishers;
    }

    @Override
    public Publisher getPublisherById(Integer publisherId) {
        try{
            Publisher publisher = publisherJpaRepository.findById(publisherId).get();
            return publisher;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Publisher addPublisher(Publisher publisher) {
        publisherJpaRepository.save(publisher);
        return publisher;
    }

    @Override
    public Publisher updatePublisher(int publisherId, Publisher publisher) {
        try{
            Publisher new_publisher = publisherJpaRepository.findById(publisherId).get();
            if(publisher.getPublisherName()!=null)new_publisher.setPublisherName(publisher.getPublisherName());
            publisherJpaRepository.save(new_publisher);
            return new_publisher;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePublisher(int publisherId) {
        try{
            publisherJpaRepository.deleteById(publisherId);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
