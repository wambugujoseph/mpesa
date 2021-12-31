
package com.transsaction.mpesa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class B2CRequest {

    @JsonProperty("Amount")
    private String mAmount;
    @JsonProperty("CommandID")
    private String mCommandID;
    @JsonProperty("InitiatorName")
    private String mInitiatorName;
    @JsonProperty("Occassion")
    private String mOccassion;
    @JsonProperty("PartyA")
    private String mPartyA;
    @JsonProperty("PartyB")
    private String mPartyB;
    @JsonProperty("QueueTimeOutURL")
    private String mQueueTimeOutURL;
    @JsonProperty("Remarks")
    private String mRemarks;
    @JsonProperty("ResultURL")
    private String mResultURL;
    @JsonProperty("SecurityCredential")
    private String mSecurityCredential;

}
