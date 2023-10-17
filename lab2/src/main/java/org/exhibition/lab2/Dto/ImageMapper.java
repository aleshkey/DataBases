package org.exhibition.lab2.Dto;

import com.fasterxml.jackson.databind.JsonNode;
import org.exhibition.lab2.model.Hall;
import org.exhibition.lab2.model.Image;
import org.exhibition.lab2.service.AuthorService;
import org.exhibition.lab2.service.ImageService;
import org.exhibition.lab2.service.Service;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper implements Mapper<Image>{
    @Autowired
    private ImageService imageService;

    @Autowired
    private AuthorService authorService;

    @Override
    public Service<Image> getService() {
        return imageService;
    }

    @Override
    public Image fromJson(JsonNode modelInJson) {
        JSONObject jsonObject = new JSONObject(modelInJson.toString());
        Image model = new Image();
        model.setExecution(jsonObject.getString("execution"));
        model.setCreationDate(jsonObject.getString("creationDate"));
        model.setAuthor(authorService.findByName(jsonObject.getString("author")));
        model.setName(jsonObject.getString("name"));
        return model;
    }
}
