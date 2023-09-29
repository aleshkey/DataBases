package org.exhibition.lab2.Dto;

import org.exhibition.lab2.model.Hall;
import org.exhibition.lab2.service.HallService;
import org.exhibition.lab2.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HallMapper implements Mapper<Hall>{
    @Autowired
    private HallService hallService;

    @Override
    public Service<Hall> getService() {
        return hallService;
    }

    @Override
    public Class<Hall> getModelClass() {
        return Hall.class;
    }
}
