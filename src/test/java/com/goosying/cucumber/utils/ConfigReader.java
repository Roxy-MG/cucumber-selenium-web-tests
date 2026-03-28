package com.goosying.cucumber.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config/config.properties")) {
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("配置文件加载失败", e);
        }
    }

    public static String getConfig(String key) {
        // 优先使用系统变量
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.isEmpty()) {
            return systemValue;
        }
        String configValue = properties.getProperty(key);
        if (configValue == null) {
            throw new RuntimeException("配置项不存在: " + key);
        }
        return configValue;
    }

}
