package com.utm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {
    private static ConfigurationManager instance = null;
    private final Properties props;

    private ConfigurationManager() {
        props = new Properties();
        try {
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
                    + "/src/main/resources/config.properties");
            props.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    public Properties getProperties() {
        return props;
    }
}

