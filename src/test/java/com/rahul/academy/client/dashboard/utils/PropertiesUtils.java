package com.rahul.academy.client.dashboard.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {

    //protected ;

    public static Properties readFile(String filePath) {
        File file = new File(filePath);
        try {
            InputStream inputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
