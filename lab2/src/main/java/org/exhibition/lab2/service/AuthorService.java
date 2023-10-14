package org.exhibition.lab2.service;

import org.exhibition.lab2.model.Author;
import org.exhibition.lab2.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements org.exhibition.lab2.service.Service<Author> {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public CrudRepository<Author, Long> getRepository() {
        return authorRepository;
    }

    public Author findByName (String name){
        return authorRepository.findByName(name);
    }
}
