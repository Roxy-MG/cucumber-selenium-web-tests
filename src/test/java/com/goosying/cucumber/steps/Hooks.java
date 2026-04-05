package com.goosying.cucumber.steps;

import com.goosying.cucumber.common.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Hooks {

    private final DriverManager driverManager;

    public Hooks(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Before
    public void openDriver(Scenario scenario) {
        if (driverManager.isCI()){
            driverManager.setDriver("chrome");
            return;
        }
        String driverType = "chrome";
        if(scenario.getSourceTagNames().contains("@edge")){
            driverType = "edge";
        }
        driverManager.setDriver(driverType);
    }

    @After
    public void quitDriver(Scenario scenario){
        if (scenario.isFailed() && driverManager != null){
            // 添加截图到测试报告
            try{
                String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
                scenario.attach(((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName()+"_"+time);
            } catch (Exception e){
                scenario.log("截图失败："+ e.getMessage());
            }
        }
        if(driverManager != null) {
            driverManager.getDriver().quit();
        }
    }
}
