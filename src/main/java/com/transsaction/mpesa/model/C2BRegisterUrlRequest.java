package com.transsaction.mpesa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class C2BRegisterUrlRequest {

    @JsonProperty("ShortCode")
    private String ShortCode;

    @JsonProperty("ResponseType")
    private String ResponseType;

    @JsonProperty("ConfirmationURL")
    private String ConfirmationURL;

    @JsonProperty("ValidationURL")
    private String ValidationURL;
}
