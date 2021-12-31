package com.transsaction.mpesa.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@Slf4j
public class HelperUtil {

    public static String getAuthKey(String consumerKey, String consumerSecret) {
        String auth_key = consumerKey +":"+consumerSecret;
        //Encode to Base64
        return toBase64String(auth_key);
    }

    public static String getObjectToJsonString(Object obj){
        try {
            String objJsonStr = new ObjectMapper().writeValueAsString(obj);
            log.info(objJsonStr);
            return objJsonStr;
        } catch (JsonProcessingException e) {
            String error = String.format("Failed %s to map to JSON string: %s", obj.getClass().getName(), e.getMessage());
            //e.printStackTrace();
            log.info(error);
            return error;
        }
    }

    public static String toBase64String(String value){
        byte[] bytes = value.getBytes(StandardCharsets.ISO_8859_1);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String getStkPushPassword(String shortCode, String passKey, String timestamp){
        String concatString = String.format("%s%s%s", shortCode, passKey, timestamp);
        return toBase64String(concatString);
    }

    public static String getTransactionTimestamp(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(new Date());
    }

    public static String getTransactionNumber(){
        RandomStringGenerator stringGenerator = new RandomStringGenerator
                .Builder()
                .withinRange('0', 'Z')
                .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                .build();
        String transactionNumber = stringGenerator.generate(12).toLowerCase();

        log.info("Transaction Number: "+transactionNumber);

        return transactionNumber;
    }

    /**
     * The Method performs encryption of the  initiatorPassword
     * Using the OpenSSL by extracting the public key form the certificate
     * @return initiatorPassword
     */
    public static String getB2CSecurityCredential(String initiatorPassword){
        // TODO implementation of the method description

        return "aolF+IzcLycZZ8Lnvl045WQJYzkB5XBWX46YJNjmPEYfGSwZKndGedt/VqkSbukXv6vR3XardPuPy1UShBrO9cJtJae0He0CNUsLkgw9yDlf+RGh+RUAE17hCXvAhPnYiKWSwFZproDfpW8vtUl4vAez/yHdKZbWY1378lXT/jvQ02q/wfNNgMfagRFUdCZZf7ub6PY5Q49WBaMsSzTXz8+5t9TYan8PuaHlJVQw77Z8zfdIEldaW4yc7li2+8YQS6une13C1wHoXCdpwa9H2cYbsBb5vOxZeI1uTzp4s0/QH73vFHq/TmXHYqyJLQmEGpb/xHDe/7N1KOs0c82wZg==";
    }
}
