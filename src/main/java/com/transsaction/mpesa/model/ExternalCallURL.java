package com.transsaction.mpesa.model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:values.yml")
public class ExternalCallURL {

    @Value("${authorization_url}")
    public String authorizationUrl;

    @Value("${confirmation_validation_url}")
    public String regConfirmationValidationUrl;

    @Value("${c2b_simulate_transaction_url}")
    public String simulateC2BTransactionUrl;

    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    public String getRegConfirmationValidationUrl() {
        return regConfirmationValidationUrl;
    }

    public String getSimulateC2BTransactionUrl() {
        return simulateC2BTransactionUrl;
    }
}
