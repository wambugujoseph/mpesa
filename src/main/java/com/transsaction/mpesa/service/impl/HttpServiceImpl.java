package com.transsaction.mpesa.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transsaction.mpesa.Config.MpsConfigs;
import com.transsaction.mpesa.model.*;
import com.transsaction.mpesa.service.HttpService;
import com.transsaction.mpesa.util.AppConst;
import com.transsaction.mpesa.util.HelperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpServiceImpl implements HttpService {

    @Autowired
    private MpsConfigs mpsConfigs;
    @Autowired
    private ConsumerComponent consumerComponent;

    @Autowired
    private ExternalCallURL externalCallURL;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpService.class);

    @Override
    public Authorized getApiAuthToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(consumerComponent.getAuthKey());

        HttpEntity request = new HttpEntity( headers);


        ResponseEntity<Authorized> response;
        try {
            response = restTemplate.exchange(
                    externalCallURL.getAuthorizationUrl(),
                    HttpMethod.GET,
                    request,
                    Authorized.class
            );
            LOGGER.info(response.getBody().toString());
        } catch (RestClientException e) {
            //Custom error response
            response = new ResponseEntity<>(
                    new Authorized("Invalid grant type passed OR Invalid Authentication passed"),
                    HttpStatus.UNAUTHORIZED);
        }

        //Check for unauthorised
        if(response.getStatusCode().is4xxClientError()){
            LOGGER.info("Unauthorised request : caused by Invalid grant type passed OR Invalid Authentication passed");
        }

        return response.getBody();
    }

    @Override
    public Object regC2BConfirmationValidationURl() {
        C2BRegisterUrlRequest confirmationValidationUrl = new C2BRegisterUrlRequest();

        HttpHeaders headers = getHttpHeaders();


        HttpEntity request = new HttpEntity(confirmationValidationUrl, headers);


        ResponseEntity<Object> response = null;
        try {
            LOGGER.info(new ObjectMapper().writeValueAsString(request.getBody()));
            response = restTemplate.postForEntity(
                    externalCallURL.getRegConfirmationValidationUrl(),
                    request,
                    Object.class
            );

        } catch (RestClientException e) {
            //Custom error response

            e.printStackTrace();
            response = new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.UNAUTHORIZED);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //Check for unauthorised
        if(response.getStatusCode().is4xxClientError()){
            LOGGER.info("The URL registration request FAILED");
        }

        return response.getBody();
    }

    @Override
    public Object simulateC2BTransaction() {
        C2BSimulateTransaction confirmationValidation = new C2BSimulateTransaction();


        HttpEntity request = new HttpEntity(confirmationValidation, getHttpHeaders());


        ResponseEntity<Object> response = null;
        try {
            LOGGER.info(new ObjectMapper().writeValueAsString(request.getBody()));
            response = restTemplate.postForEntity(
                    externalCallURL.getSimulateC2BTransactionUrl(),
                    request,
                    Object.class
            );

        } catch (RestClientException e) {
            //Custom error response

            e.printStackTrace();
            response = new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.UNAUTHORIZED);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //Check for unauthorised
        if(response.getStatusCode().is4xxClientError()){
            LOGGER.info("FAILED to simulate transaction");
        }

        return response.getBody();
    }

    @Override
    public Object performStkPushTransaction(StkPushCustomer stkPushCustomer) {
        StkPushRequest stkPushRequest = new StkPushRequest();

        String transactionTimestamp= HelperUtil.getTransactionTimestamp();
        String stkPushPassword = HelperUtil.getStkPushPassword(
                mpsConfigs.getStkPushShortCode(),mpsConfigs.getStkPassKey(), transactionTimestamp);

        stkPushRequest.setMPassword(stkPushPassword);
        stkPushRequest.setMTimestamp(transactionTimestamp);
        stkPushRequest.setMBusinessShortCode(mpsConfigs.getStkPushShortCode());
        stkPushRequest.setMTransactionType(AppConst.CUSTOMER_PAY_BILL_ONLINE);

        stkPushRequest.setMAmount("10");
        stkPushRequest.setMPartyA("254791510069");
        stkPushRequest.setMPartyB(mpsConfigs.getStkPushShortCode());
        stkPushRequest.setMPhoneNumber("254791510069");
        stkPushRequest.setMCallBackURL(mpsConfigs.getStkPushRequestCallBackUrl());

        String transactionNumber = HelperUtil.getTransactionNumber();

        stkPushRequest.setMAccountReference(transactionNumber);
        stkPushRequest.setMTransactionDesc("254791510069 : Transaction number = "+transactionNumber);



        HttpEntity request = new HttpEntity(stkPushRequest, getHttpHeaders());


        ResponseEntity<Object> response = null;
        try {
            LOGGER.info(new ObjectMapper().writeValueAsString(request.getBody()));
            response = restTemplate.postForEntity(
                    mpsConfigs.getStkPushRequestUrl(),
                    request,
                    Object.class
            );

        } catch (RestClientException e) {
            //Custom error response

            e.printStackTrace();
            response = new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.UNAUTHORIZED);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //Check for unauthorised
        if(response.getStatusCode().is4xxClientError()){
            LOGGER.info("FAILED To process the StkPush");
        }

        return response.getBody();
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();

        //Get and allocate access_token
        String access_token = getApiAuthToken().getAccess_token();
        headers.setBearerAuth(access_token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        LOGGER.info(access_token);
        return headers;
    }
}

