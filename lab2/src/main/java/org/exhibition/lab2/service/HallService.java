package org.exhibition.lab2.service;

import org.exhibition.lab2.model.Hall;
import org.exhibition.lab2.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class HallService implements org.exhibition.lab2.service.Service<Hall> {
    @Autowired
    private HallRepository hallRepository;

    @Override
    public CrudRepository<Hall, Long> getRepository() {
        return hallRepository;
    }
}
