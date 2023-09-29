package org.exhibition.lab2.service;

import org.exhibition.lab2.model.Image;
import org.exhibition.lab2.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageService implements org.exhibition.lab2.service.Service<Image> {
    @Autowired
    ImageRepository imageRepository;

    @Override
    public CrudRepository<Image, Long> getRepository() {
        return imageRepository;
    }
}
