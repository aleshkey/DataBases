package org.exhibition.lab2.service;

import org.exhibition.lab2.model.Owner;
import org.exhibition.lab2.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class OwnerService implements org.exhibition.lab2.service.Service<Owner> {

    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public CrudRepository<Owner, Long> getRepository() {
        return ownerRepository;
    }

    public Owner getOwnerByName(String name){
        return ownerRepository.findByName(name).orElse(new Owner());
    }
}
