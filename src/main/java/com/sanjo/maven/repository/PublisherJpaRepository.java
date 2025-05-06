package com.sanjo.maven.repository;


import com.sanjo.maven.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherJpaRepository extends JpaRepository<Publisher,Integer> {

}
