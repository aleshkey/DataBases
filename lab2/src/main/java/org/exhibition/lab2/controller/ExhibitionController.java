package org.exhibition.lab2.controller;

import org.exhibition.lab2.Dto.ExhibitionMapper;
import org.exhibition.lab2.Dto.Mapper;
import org.exhibition.lab2.model.Exhibition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exhibitions")
public class ExhibitionController implements CrudController<Exhibition>{
    @Autowired
    private ExhibitionMapper exhibitionMapper;

    @Override
    public Mapper<Exhibition> getMapper() {
        return exhibitionMapper;
    }

    @Override
    public String getStartURL() {
        return "/exhibitions";
    }
}
