
package com.transsaction.mpesa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StkPushResponse {

    @JsonProperty("Body")
    private Body body;

}
