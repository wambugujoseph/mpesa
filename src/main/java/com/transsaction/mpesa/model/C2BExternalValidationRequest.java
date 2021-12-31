
package com.transsaction.mpesa.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class C2BExternalValidationRequest {

    @JsonProperty("BillRefNumber")
    private String billRefNumber;
    @JsonProperty("BusinessShortCode")
    private String businessShortCode;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("MSISDN")
    private String mSISDN;
    @JsonProperty("MiddleName")
    private String middleName;
    @JsonProperty("OrgAccountBalance")
    private String orgAccountBalance;
    @JsonProperty("ThirdPartyTransID")
    private String thirdPartyTransID;
    @JsonProperty("TransAmount")
    private String transAmount;
    @JsonProperty("TransID")
    private String transID;
    @JsonProperty("TransTime")
    private String transTime;
    @JsonProperty("TransactionType")
    private String transactionType;


}
