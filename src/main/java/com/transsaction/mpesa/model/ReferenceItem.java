
package com.transsaction.mpesa.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReferenceItem {

    @JsonProperty("Key")
    private String mKey;
    @JsonProperty("Value")
    private String mValue;

}
