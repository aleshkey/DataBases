package org.exhibition.lab2.controller;

import org.exhibition.lab2.Dto.ImageMapper;
import org.exhibition.lab2.Dto.Mapper;
import org.exhibition.lab2.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("images")
public class ImageController implements CrudController<Image>{

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public Mapper<Image> getMapper() {
        return imageMapper;
    }

    @Override
    public String getStartURL() {
        return "/images";
    }
}
