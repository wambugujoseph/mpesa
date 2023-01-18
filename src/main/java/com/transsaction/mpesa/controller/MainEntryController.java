package com.transsaction.mpesa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transsaction.mpesa.model.*;
import com.transsaction.mpesa.service.AppCache;
import com.transsaction.mpesa.service.HttpService;
import com.transsaction.mpesa.util.HelperUtil;
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
    @Autowired
    private AppCache appCache;



    @GetMapping(value = "/")
    public String testApp() {
        appCache.evictFromCache("test1");
        appCache.addToCache("test1", "Test pass");
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

    @RequestMapping(value = "/simulate_c2b", method=RequestMethod.POST)
    public Object simulateC2BTransaction(@RequestBody C2BCustomer customer) {
        return httpService.simulateC2BTransaction(customer);
    }

    @SneakyThrows
    @RequestMapping(value = "/ss/confirm")
    public Object getStkPush(@RequestBody StkPushResponse data) {
        log.info("========++++++ StkPushCallBack Processed");
        log.info("Callback Data: " + HelperUtil.getObjectToJsonString(data));
        return data;
    }

    @RequestMapping(value = "/stk_push", method = RequestMethod.POST)
    public Object getStkPushRequest(@RequestBody StkPushCustomer stkPushCustomer) {

        if (stkPushCustomer == null) {
            return "Invalid StkPushCustomer";
        }
        return httpService.performStkPushTransaction(stkPushCustomer);
    }

    @RequestMapping(value = "/b2c_transaction_result", method = RequestMethod.POST)
    public Object b2cTransactionResult(@RequestBody B2CSuccessResult b2CSuccessResult){
        log.info(" ======== Processing B2C transaction result response");
        log.info(HelperUtil.getObjectToJsonString(b2CSuccessResult));
        return b2CSuccessResult;
    }
    
    @RequestMapping(value ="/transaction_queue_timeout", method = RequestMethod.POST)
    public Object b2cTransactionQueueTimeOut(@RequestBody Object obj){
        log.info(String.format("%s",HelperUtil.getObjectToJsonString(obj) ));
        return obj;
    }

    @RequestMapping(value = "b2c_transaction")
    public Object performB2CTransaction(@RequestBody B2CTransactionRequest b2CTransactionRequest){
        return httpService.performB2CTransaction(b2CTransactionRequest);
    }
}
