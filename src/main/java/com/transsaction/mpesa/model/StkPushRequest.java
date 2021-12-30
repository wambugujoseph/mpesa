package com.transsaction.mpesa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.context.annotation.PropertySource;



@Data
public class StkPushRequest {

    @JsonProperty("AccountReference")
    private String mAccountReference;

    @JsonProperty("Amount")
    private String mAmount;

    @JsonProperty("BusinessShortCode")
    private String mBusinessShortCode;

    @JsonProperty("CallBackURL")
    private String mCallBackURL;

    @JsonProperty("PartyA")
    private String mPartyA;

    @JsonProperty("PartyB")
    private String mPartyB;

    @JsonProperty("Password")
    private String mPassword;

    @JsonProperty("PhoneNumber")
    private String mPhoneNumber;

    @JsonProperty("Timestamp")
    private String mTimestamp;

    @JsonProperty("TransactionDesc")
    private String mTransactionDesc;

    @JsonProperty("TransactionType")
    private String mTransactionType;

}
