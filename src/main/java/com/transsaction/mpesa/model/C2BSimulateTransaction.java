package com.transsaction.mpesa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class C2BSimulateTransaction {
    @JsonProperty("ShortCode")
    private String ShortCode = "600998";

    @JsonProperty("CommandID")
    private String CommandID = "CustomerBuyGoodsOnline";

    @JsonProperty("Amount")
    private String Amount = "100";

    @JsonProperty("Msisdn")
    private String Msisdn = "254708374149";

    @JsonProperty("BillRefNumber")
    private String BillRefNumber = "254708374149";
}
