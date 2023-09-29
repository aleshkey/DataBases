package org.exhibition.lab2.Dto;

import org.exhibition.lab2.model.Owner;
import org.exhibition.lab2.service.OwnerService;
import org.exhibition.lab2.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper implements Mapper<Owner>{
    @Autowired
    private OwnerService ownerService;

    @Override
    public Service<Owner> getService() {
        return ownerService;
    }

    @Override
    public Class<Owner> getModelClass() {
        return Owner.class;
    }
}
