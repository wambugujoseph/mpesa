package com.transsaction.mpesa.Config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("classpath:values.yml")
public class MpsConfigs {

    @Value("${stkPassKey}")
    private String stkPassKey;
    @Value("${stkPushShortCode}")
    private String stkPushShortCode;
    @Value("${stkPushRequestUrl}")
    private String stkPushRequestUrl;
    @Value("${stkPushRequestCallBackUrl}")
    private String stkPushRequestCallBackUrl;
}
