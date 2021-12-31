package com.transsaction.mpesa.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.transsaction.mpesa.model.Authorized;
import com.transsaction.mpesa.model.C2BCustomer;
import com.transsaction.mpesa.model.StkPushCustomer;


public interface HttpService {

    Authorized getApiAuthToken() throws JsonProcessingException;
    Object regC2BConfirmationValidationURl();
    Object simulateC2BTransaction(C2BCustomer customer);
    Object performStkPushTransaction(StkPushCustomer stkPushCustomer);
}
