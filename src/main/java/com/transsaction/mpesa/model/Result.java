
package com.transsaction.mpesa.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Result {

    @JsonProperty("ConversationID")
    private String mConversationID;
    @JsonProperty("OriginatorConversationID")
    private String mOriginatorConversationID;
    @JsonProperty("ReferenceData")
    private ReferenceData mReferenceData;
    @JsonProperty("ResultCode")
    private Long mResultCode;
    @JsonProperty("ResultDesc")
    private String mResultDesc;
    @JsonProperty("ResultParameters")
    private ResultParameters mResultParameters;
    @JsonProperty("ResultType")
    private Long mResultType;
    @JsonProperty("TransactionID")
    private String mTransactionID;

}
