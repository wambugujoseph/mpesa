package com.transsaction.mpesa.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Base64;


@Component
@PropertySource("classpath:values.yml")
public class ConsumerComponent {

    @Value("${consumer_key}")
    private String consumerKey;

    @Value("${consumer_secret}")
    private String consumerSecret;

    private String authKey;

    public ConsumerComponent() {
    }

    public String getConsumerKey() {
        return consumerKey;
    }


    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getAuthKey() {
        String auth_key = getConsumerKey() +":"+getConsumerSecret();
        //Encode to Base64
        return Base64.getEncoder().encodeToString(auth_key.getBytes());
    }

    private void setAuthKey(String authKey) {
        this.authKey = authKey;
    }
}
