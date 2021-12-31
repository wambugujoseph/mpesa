package com.transsaction.mpesa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transsaction.mpesa.model.Authorized;
import com.transsaction.mpesa.model.C2BCustomer;
import com.transsaction.mpesa.model.StkPushCustomer;
import com.transsaction.mpesa.model.StkPushResponse;
import com.transsaction.mpesa.service.HttpService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Slf4j
public class MainEntryController {

    @Autowired
    private HttpService httpService;

    @GetMapping(value = "/")
    public String testApp() {
        return "Index App";
    }

    @GetMapping(value = "/authorize")
    public Authorized getAuthorizationToken() {
        try {
            return httpService.getApiAuthToken();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new Authorized();
    }

    @RequestMapping(value = "/confirmation")
    public Object mpesaConfirmation() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            log.info("CONFIRMATION : ");
            return "data";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/validation")
    public Object mpesaValidation() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            log.info("VALIDATION : ");
            return "data";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/reg_url")
    public Object regC2bConfirmationValidationUrl() {
        return httpService.regC2BConfirmationValidationURl();
    }

    @RequestMapping(value = "simulate_c2b", method=RequestMethod.POST)
    public Object simulateC2BTransaction(@RequestBody C2BCustomer customer) {
        return httpService.simulateC2BTransaction(customer);
    }

    @SneakyThrows
    @RequestMapping(value = "/stk/confirm")
    public Object getStkPush(@RequestBody StkPushResponse data) {
        log.info("========++++++ StkPushCallBack Processed");
        log.info("Callback Data: " + new ObjectMapper().writeValueAsString(data));
        return data;
    }

    @RequestMapping(value = "/stk_push", method = RequestMethod.POST)
    public Object getStkPushRequest(@RequestBody StkPushCustomer stkPushCustomer) {

        if (stkPushCustomer == null) {
            return "Invalid StkPushCustomer";
        }
        return httpService.performStkPushTransaction(stkPushCustomer);
    }

}
