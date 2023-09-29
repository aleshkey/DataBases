package org.exhibition.lab2.Dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.exhibition.lab2.model.Hall;
import org.exhibition.lab2.model.Owner;
import org.exhibition.lab2.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HallMapper {
    @Autowired
    private HallService hallService;

    public List<Hall> getAll(){
        return hallService.getAll();
    }

    public Hall findById(int id){
        return hallService.findById(id);
    }

    public void addHall(JsonNode hallInJson){
        ObjectMapper jsonObjectMapper = new ObjectMapper();
        Hall newHall = new Hall();
        try {
            newHall = jsonObjectMapper.treeToValue(hallInJson, Hall.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        hallService.save(newHall);
    }

    public void deleteById(int id){
        hallService.deleteById(id);
    }

    public void updateHall(int id, JsonNode hallInJson){
        ObjectMapper jsonObjectMapper = new ObjectMapper();
        Hall newHall = new Hall();
        try {
            newHall = jsonObjectMapper.treeToValue(hallInJson, Hall.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        newHall.setId(id);
        hallService.save(newHall);
    }
}
