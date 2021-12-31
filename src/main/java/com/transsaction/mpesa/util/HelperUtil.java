package com.transsaction.mpesa.util;


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
}
