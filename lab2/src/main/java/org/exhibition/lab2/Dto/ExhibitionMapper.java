package org.exhibition.lab2.Dto;

import org.exhibition.lab2.model.Exhibition;
import org.exhibition.lab2.service.ExhibitionService;
import org.exhibition.lab2.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExhibitionMapper implements Mapper<Exhibition>{
    @Autowired
    ExhibitionService exhibitionService;

    @Override
    public Service<Exhibition> getService() {
        return exhibitionService;
    }

    @Override
    public Class<Exhibition> getModelClass() {
        return Exhibition.class;
    }
}
