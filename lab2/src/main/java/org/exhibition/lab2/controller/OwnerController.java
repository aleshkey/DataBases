package org.exhibition.lab2.controller;

import org.exhibition.lab2.Dto.Mapper;
import org.exhibition.lab2.Dto.OwnerMapper;
import org.exhibition.lab2.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("owners")
public class OwnerController implements CrudController<Owner>{
    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public Mapper<Owner> getMapper() {
        return ownerMapper;
    }

    @Override
    public String getStartURL() {
        return "/owners";
    }
}
