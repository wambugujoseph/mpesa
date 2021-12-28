package com.transsaction.mpesa.model;

import org.springframework.stereotype.Component;

@Component
public class Authorized {

    private String  access_token;
    private double expires_in;
    private String errorMessage;

    public Authorized() {
    }

    public Authorized(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public double getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(double expires_in) {
        this.expires_in = expires_in;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
