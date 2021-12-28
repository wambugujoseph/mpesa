package com.transsaction.mpesa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.transsaction.mpesa.model.Authorized;
import com.transsaction.mpesa.model.ConsumerComponent;
import com.transsaction.mpesa.service.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApp {

    @Autowired
    private ConsumerComponent consumerComponent;

    @Autowired
    private HttpService httpService;

    @GetMapping(value="/")
    public String testApp() {

        return consumerComponent.getAuthKey();
    }

    @GetMapping(value="/authorize")
    public Authorized getAuthorizationToken(){
        try {
            return httpService.getApiAuthToken();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new Authorized();
    }

}
