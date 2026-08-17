package com.rahul.academy.client.dashboard.utils;

import java.util.Properties;

public class ConfigUtils {
    private static ConfigUtils configUtils;
    private Properties properties;

    private ConfigUtils(){
        properties = PropertiesUtils.readFile("src/test/java/com/rahul/academy/client/dashboard/config/production.properties");
    }

    public static ConfigUtils getInstance(){
        if(configUtils == null){
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getBaseURL(){
        String baseUrl= properties.getProperty("baseURL");
        if(baseUrl != null) {return baseUrl;}

        throw new RuntimeException("the baseURL value not found in the file");
    }

    public String getUserEmail() {
        String userEmail= properties.getProperty("userEmail");

        if(userEmail != null) {return userEmail;}
        throw new RuntimeException("the user email value not found in the file");
    }

    public String getUserPassword() {
        String userPassword= properties.getProperty("userPassword");

        if(userPassword != null) {return userPassword;}
        throw new RuntimeException("the password value not found in the file");
    }

    public String getProductName() {
        String productName= properties.getProperty("productName");

        if(productName != null) {return productName;}
        throw new RuntimeException("the product name value not found in the file");
    }

    public String getCountryName() {
        String countryName= properties.getProperty("countryName");

        if(countryName != null) {return countryName;}
        throw new RuntimeException("the country name value not found in the file");
    }
}
