package org.exhibition.lab2.repository;


import org.exhibition.lab2.model.Hall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends CrudRepository<Hall, Long> {}