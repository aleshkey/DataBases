package org.exhibition.lab2.controller;

import org.exhibition.lab2.Dto.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @Autowired
    AuthorMapper authorMapper;


}
