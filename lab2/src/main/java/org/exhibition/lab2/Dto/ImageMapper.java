package org.exhibition.lab2.Dto;

import org.exhibition.lab2.model.Image;
import org.exhibition.lab2.service.ImageService;
import org.exhibition.lab2.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper implements Mapper<Image>{
    @Autowired
    private ImageService imageService;

    @Override
    public Service<Image> getService() {
        return imageService;
    }

    @Override
    public Class<Image> getModelClass() {
        return Image.class;
    }
}
