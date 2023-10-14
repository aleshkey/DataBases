package org.exhibition.lab2.Dto;

import com.fasterxml.jackson.databind.JsonNode;
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

    T fromJson(JsonNode modelInJson);

    default void add(JsonNode modelInJson){
        T newModel = fromJson(modelInJson);
        getService().save(newModel);
    }

    default void deleteById(int id){
        getService().deleteById(id);
    }

    default void update(int id, JsonNode modelInJson){
        T newModel = fromJson(modelInJson);
        newModel.setId(id);
        getService().save(newModel);
    }
}
