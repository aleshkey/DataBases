package org.exhibition.lab2.Dto;

import com.fasterxml.jackson.databind.JsonNode;
import org.exhibition.lab2.model.Author;
import org.exhibition.lab2.service.AuthorService;
import org.exhibition.lab2.service.Service;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements Mapper<Author>{
    @Autowired
    private AuthorService authorService;

    @Override
    public Service<Author> getService() {
        return authorService;
    }

    @Override
    public Author fromJson(JsonNode modelInJson) {
        JSONObject jsonObject = new JSONObject(modelInJson.toString());
        Author model = new Author();
        model.setName(jsonObject.getString("name"));
        model.setPlaceOfBirth(jsonObject.getString("placeOfBirth"));
        model.setBiography(jsonObject.getString("biography"));
        model.setEducation(jsonObject.getString("education"));
        return model;
    }


}
