package com.goosying.cucumber.common;

import com.goosying.cucumber.utils.ConfigReader;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

@Getter
public class DriverManager {
    // 通过PicoContainer，让Scenario共用一个实例
    private WebDriver driver;

    // 初始化浏览器
    public void setDriver(String driverType) {
        boolean isCI = System.getenv("CI") != null;
        if (driver == null) {
            if("chrome".equals(driverType)){
                ChromeOptions options = new ChromeOptions();
                String option = ConfigReader.getConfig("chrome.options");
                if (option != null && !option.isBlank()){
                    options.addArguments(option.split("\\s+"));
                }
                if (isCI){
                    options.addArguments("--headless");
                    options.addArguments("--window-size=1920,1080");
                }
                driver = new ChromeDriver(options);
            }else if("edge".equals(driverType)){
                driver = new EdgeDriver();
            }
            if (!isCI) {
                driver.manage().window().maximize();
            }
        }
    }
}
