package com.transsaction.mpesa.Config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("classpath:values.yml")
public class MpsConfigs {
    @Value("${consumer_key}")
    private String consumerKey;
    @Value("${consumer_secret}")
    private String consumerSecret;

    @Value("${shortCode}")
    private String shortCode;
    @Value("${responseType}")
    private String responseType;
    @Value("${confirmationURL}")
    private String confirmationURL;
    @Value("${validationURL}")
    private String validationURL;

    @Value("${stkPassKey}")
    private String stkPassKey;
    @Value("${stkPushShortCode}")
    private String stkPushShortCode;
    @Value("${stkPushRequestUrl}")
    private String stkPushRequestUrl;
    @Value("${stkPushRequestCallBackUrl}")
    private String stkPushRequestCallBackUrl;

    @Value("${b2cTransactionURL}")
    private String b2cTransactionURL;
    @Value("${b2cInitiatorName}")
    private String b2cInitiatorName;
    @Value("${b2cQueueTimeOutURL}")
    private String b2cQueueTimeOutURL;
    @Value("${b2cResultURL}")
    private String b2cResultURL;
    @Value("${b2cInitiatorPassword}")
    private String b2cInitiatorPassword;

}
