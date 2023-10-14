package org.exhibition.lab2.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.exhibition.lab2.Dto.Mapper;
import org.exhibition.lab2.model.Model;
import org.json.JSONArray;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 2000,
        allowedHeaders = "*", allowCredentials = "true")
public interface CrudController <T extends Model>{

    Mapper<T> getMapper();

    String getStartURL();

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    default List<T> getAll(){
        return getMapper().getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    default T getSingle(@PathVariable int id){
        return getMapper().findById(id);
    }

    @GetMapping(value = "/add")
    default void add(){}

    @PostMapping(value = "")
    default RedirectView create(@RequestBody JsonNode hallInJson){
        getMapper().add(hallInJson);
        return new RedirectView(getStartURL());
    }

    @PostMapping(value = "/{id}/delete")
    default RedirectView deleteById(@PathVariable int id){
        getMapper().deleteById(id);
        return new RedirectView(getStartURL());
    }

    @GetMapping(value = "/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE)
    default T update(@PathVariable int id){
        return getMapper().findById(id);
    }

    @PostMapping(value = "/{id}")
    default RedirectView updateById(@PathVariable int id, @RequestBody JsonNode hallInJson){
        getMapper().update(id, hallInJson);
        return new RedirectView(getStartURL()+"/"+id);
    }
}
