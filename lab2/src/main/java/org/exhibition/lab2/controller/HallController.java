package org.exhibition.lab2.controller;

import org.exhibition.lab2.Dto.HallMapper;
import org.exhibition.lab2.Dto.Mapper;
import org.exhibition.lab2.model.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("halls")

public class HallController implements CrudController<Hall>{

    @Autowired
    private HallMapper hallMapper;

    @Override
    public Mapper<Hall> getMapper() {
        return hallMapper;
    }

    @Override
    public String getStartURL() {
        return "/halls";
    }
}
