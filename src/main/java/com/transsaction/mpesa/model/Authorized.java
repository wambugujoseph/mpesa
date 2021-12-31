package com.transsaction.mpesa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Authorized {

    private String access_token;
    private double expires_in;
    private String errorMessage;

    public Authorized() {
    }
    public Authorized(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
