package com.transsaction.mpesa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class C2BRegisterUrlRequest {

    @JsonProperty("ShortCode")
    private String ShortCode = "600999";

    @JsonProperty("ResponseType")
    private String ResponseType = "Completed";

    @JsonProperty("ConfirmationURL")
    private String ConfirmationURL;

    @JsonProperty("ValidationURL")
    private String ValidationURL;
}
