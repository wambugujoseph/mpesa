package com.transsaction.mpesa.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.transsaction.mpesa.model.Authorized;


public interface HttpService {

    Authorized getApiAuthToken() throws JsonProcessingException;
    Object regC2BConfirmationValidationURl();
}
