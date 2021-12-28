package com.transsaction.mpesa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transsaction.mpesa.model.Authorized;
import com.transsaction.mpesa.model.ConsumerComponent;
import com.transsaction.mpesa.service.HttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApp {

    public static Logger logger = LoggerFactory.getLogger(TestApp.class);

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

    @RequestMapping(value="/comfirmation")
    public void mpesaConfirmation(@RequestBody Object data){
        ObjectMapper mapper = new ObjectMapper();

        try {
            logger.info(mapper.writeValueAsString(data));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
