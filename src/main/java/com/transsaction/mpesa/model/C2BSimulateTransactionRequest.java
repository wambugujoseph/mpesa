package com.transsaction.mpesa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class C2BSimulateTransactionRequest {
    @JsonProperty("ShortCode")
    private String ShortCode;

    @JsonProperty("CommandID")
    private String CommandID;

    @JsonProperty("Amount")
    private String Amount;

    @JsonProperty("Msisdn")
    private String Msisdn;

    @JsonProperty("BillRefNumber")
    private String BillRefNumber;


}
