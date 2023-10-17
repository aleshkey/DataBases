package org.exhibition.lab2.service;

import org.exhibition.lab2.model.Exhibition;
import org.exhibition.lab2.repository.ExhibitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ExhibitionService implements org.exhibition.lab2.service.Service<Exhibition> {
    @Autowired
    ExhibitionRepository exhibitionRepository;

    @Override
    public CrudRepository<Exhibition, Long> getRepository() {
        return exhibitionRepository;
    }

    public Exhibition findByName(String exhibition) {
        return exhibitionRepository.findByName(exhibition);
    }
}
