package org.exhibition.lab2.repository;

import org.exhibition.lab2.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findByName(String name);}