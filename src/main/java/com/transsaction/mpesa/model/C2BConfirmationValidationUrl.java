package com.transsaction.mpesa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class C2BConfirmationValidationUrl {

    @JsonProperty("ShortCode")
    private String ShortCode = "600980";

    @JsonProperty("ResponseType")
    private String ResponseType = "Completed";

    @JsonProperty("ConfirmationURL")
    private String ConfirmationURL = "https://cryptic-tps-mps.herokuapp.com/confirmation";

    @JsonProperty("ValidationURL")
    private String ValidationURL = "https://cryptic-tps-mps.herokuapp.com/validation";
}
