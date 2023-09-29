package org.exhibition.lab2.Dto;

import org.exhibition.lab2.model.Author;
import org.exhibition.lab2.service.AuthorService;
import org.exhibition.lab2.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements Mapper<Author>{
    @Autowired
    private AuthorService authorService;

    @Override
    public Service<Author> getService() {
        return authorService;
    }

    @Override
    public Class<Author> getModelClass() {
        return Author.class;
    }
}
