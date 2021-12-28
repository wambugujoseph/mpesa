package com.transsaction.mpesa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

public class C2BConfirmationValidationUrl {

    @JsonProperty("ShortCode")
    private String ShortCode = "174379";

    @JsonProperty("ResponseType")
    private String ResponseType = "Cancelled";

    @JsonProperty("ConfirmationURL")
    private String ConfirmationURL = "https://cryptic-tps-mps.herokuapp.com/confirmation";

    @JsonProperty("ValidationURL")
    private String ValidationURL = "https://cryptic-tps-mps.herokuapp.com/confirmation";

    public String getShortCode() {
        return ShortCode;
    }

    public void setShortCode(String shortCode) {
        ShortCode = shortCode;
    }

    public String getResponseType() {
        return ResponseType;
    }

    public void setResponseType(String responseType) {
        ResponseType = responseType;
    }

    public String getConfirmationURL() {
        return ConfirmationURL;
    }

    public void setConfirmationURL(String confirmationURL) {
        ConfirmationURL = confirmationURL;
    }

    public String getValidationURL() {
        return ValidationURL;
    }

    public void setValidationURL(String validationURL) {
        ValidationURL = validationURL;
    }
}
