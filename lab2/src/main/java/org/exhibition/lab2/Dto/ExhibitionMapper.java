package org.exhibition.lab2.Dto;

import com.fasterxml.jackson.databind.JsonNode;
import org.exhibition.lab2.model.Author;
import org.exhibition.lab2.model.Exhibition;
import org.exhibition.lab2.service.AuthorService;
import org.exhibition.lab2.service.ExhibitionService;
import org.exhibition.lab2.service.Service;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExhibitionMapper implements Mapper<Exhibition>{
    @Autowired
    ExhibitionService exhibitionService;

    @Autowired
    AuthorService authorService;

    @Override
    public Service<Exhibition> getService() {
        return exhibitionService;
    }

    @Override
    public Exhibition fromJson(JsonNode modelInJson) {
        JSONObject jsonObject = new JSONObject(modelInJson.toString());
        Exhibition model = new Exhibition();
        model.setDate(jsonObject.getString("date"));
        model.setType(jsonObject.getString("type"));
        List<Author> authors = new ArrayList<>();
        var arr = jsonObject.getJSONArray("authors");
        for (int i=0; i<arr.length(); i++){
            var elem = arr.getJSONObject(i);
            authors.add(authorService.findByName(elem.toString()));
        }
        model.setAuthors(authors);
        return model;
    }
}
