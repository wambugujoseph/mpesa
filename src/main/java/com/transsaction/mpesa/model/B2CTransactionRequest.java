package com.transsaction.mpesa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class B2CTransactionRequest {
    @JsonProperty("Remarks")
    private String mRemarks;
    @JsonProperty("Amount")
    private String mAmount;
    @JsonProperty("Occassion")
    private String mOccassion;
    @JsonProperty("CommandID")
    private String mCommandID;
    @JsonProperty("PartyB")
    private String mPartyB;
}
