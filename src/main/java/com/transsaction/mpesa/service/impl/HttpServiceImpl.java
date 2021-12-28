package com.transsaction.mpesa.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transsaction.mpesa.model.Authorized;
import com.transsaction.mpesa.model.ConsumerComponent;
import com.transsaction.mpesa.model.ExternalCallURL;
import com.transsaction.mpesa.service.HttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpServiceImpl implements HttpService {

    @Autowired
    private ConsumerComponent consumerComponent;

    @Autowired
    private ExternalCallURL externalCallURL;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpService.class);

    @Override
    public Authorized getApiAuthToken() throws JsonProcessingException {
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
}
