
package com.transsaction.mpesa.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StkCallback {

    @JsonProperty("CallbackMetadata")
    private CallbackMetadata callbackMetadata;
    @JsonProperty("CheckoutRequestID")
    private String checkoutRequestID;
    @JsonProperty("MerchantRequestID")
    private String merchantRequestID;
    @JsonProperty("ResultCode")
    private Long resultCode;
    @JsonProperty("ResultDesc")
    private String resultDesc;

}
