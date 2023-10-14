package org.exhibition.lab2.controller;

import org.exhibition.lab2.Dto.AuthorMapper;
import org.exhibition.lab2.Dto.Mapper;
import org.exhibition.lab2.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authors")
public class AuthorController implements CrudController<Author>{
    @Autowired
    AuthorMapper authorMapper;

    @Override
    public Mapper<Author> getMapper() {
        return authorMapper;
    }

    @Override
    public String getStartURL() {
        return "/authors";
    }
}
