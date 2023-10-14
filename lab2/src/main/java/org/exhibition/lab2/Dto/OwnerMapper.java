package org.exhibition.lab2.Dto;

import com.fasterxml.jackson.databind.JsonNode;
import org.exhibition.lab2.model.Owner;
import org.exhibition.lab2.service.OwnerService;
import org.exhibition.lab2.service.Service;
import org.json.JSONObject;
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
    public Owner fromJson(JsonNode modelInJson) {
        JSONObject jsonObject = new JSONObject(modelInJson.toString());
        Owner model = new Owner();
        model.setName(jsonObject.getString("name"));
        model.setAddress(jsonObject.getString("address"));
        model.setPhoneNumber(jsonObject.getString("phoneNumber"));
        return model;
    }

}
