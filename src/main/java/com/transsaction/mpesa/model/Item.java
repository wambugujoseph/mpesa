
package com.transsaction.mpesa.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Item {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Value")
    private Double value;
}
