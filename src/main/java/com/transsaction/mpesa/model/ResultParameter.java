
package com.transsaction.mpesa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResultParameter {

    @JsonProperty("Key")
    private String mKey;
    @JsonProperty("Value")
    private Long mValue;

}
