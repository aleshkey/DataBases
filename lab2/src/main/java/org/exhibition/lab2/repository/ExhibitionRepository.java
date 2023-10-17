package org.exhibition.lab2.repository;


import org.exhibition.lab2.model.Exhibition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitionRepository extends CrudRepository<Exhibition, Long> {
    Exhibition findByName(String name);}