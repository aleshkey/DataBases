package org.exhibition.lab2.service;

import org.exhibition.lab2.model.Hall;
import org.exhibition.lab2.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HallService {
    @Autowired
    private HallRepository hallRepository;

    public List<Hall> getAll(){
        List<Hall> hallList = new ArrayList<>();
        hallRepository.findAll().forEach(hallList::add);
        return hallList;
    }

    public Hall findById(int id){
        var check = hallRepository.findById(Long.valueOf(id));
        return check.orElseGet(Hall::new);
    }

    public void save(Hall hall){
        hallRepository.save(hall);
    }

    public void deleteById(int id){
        hallRepository.deleteById(Long.valueOf(id));
    }
}
