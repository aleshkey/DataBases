package org.exhibition.lab2.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.exhibition.lab2.Dto.HallMapper;
import org.exhibition.lab2.model.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("halls")
public class HallController {

    @Autowired
    private HallMapper hallMapper;

    @GetMapping(value = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Hall> getAll(){
        return hallMapper.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hall getSingle(@PathVariable int id){
        return hallMapper.findById(id);
    }

    @GetMapping(value = "/add")
    public void add(){}

    @PostMapping(value = "/add-hall")
    public RedirectView create(@RequestBody JsonNode hallInJson){
        hallMapper.addHall(hallInJson);
        return new RedirectView("/halls");
    }

    @PostMapping(value = "/{id}/delete-hall")
    public RedirectView deleteById(@PathVariable int id){
        hallMapper.deleteById(id);
        return new RedirectView("/halls");
    }

    @GetMapping(value = "/{id}/update")
    public void update(@PathVariable int id){}

    @PostMapping(value = "/{id}")
    public RedirectView updateById(@PathVariable int id, @RequestBody JsonNode hallInJson){
        hallMapper.updateHall(id, hallInJson);
        return new RedirectView("/halls/"+id);
    }
}
