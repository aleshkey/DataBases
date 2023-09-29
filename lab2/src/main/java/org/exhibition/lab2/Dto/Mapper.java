package org.exhibition.lab2.Dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.exhibition.lab2.model.Hall;
import org.exhibition.lab2.model.Model;
import org.exhibition.lab2.service.Service;

import java.util.List;

public interface Mapper <T extends Model>{

    Service<T> getService();

    default List<T> getAll(){
        return getService().getAll();
    }

    default T findById(int id){
        return getService().findById(id);
    }

    Class<T> getModelClass();

    default void add(JsonNode hallInJson){
        ObjectMapper jsonObjectMapper = new ObjectMapper();
        T newModel = null;
        try {
            newModel = jsonObjectMapper.treeToValue(hallInJson, getModelClass());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        getService().save(newModel);
    }

    default void deleteById(int id){
        getService().deleteById(id);
    }

    default void update(int id, JsonNode hallInJson){
        ObjectMapper jsonObjectMapper = new ObjectMapper();
        T newModel = null;
        try {
            newModel = jsonObjectMapper.treeToValue(hallInJson, getModelClass());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        newModel.setId(id);
        getService().save(newModel);
    }
}
