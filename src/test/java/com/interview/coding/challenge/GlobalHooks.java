package com.interview.coding.challenge;

import io.cucumber.core.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.BaseUtil;
import utils.WebDriverFactory;

import utils.properties.FrameworkProperties;



import static utils.LogUtil.info;


public class GlobalHooks {
    protected static String browser;
    private String jobName;

    public void setUP(Scenario scenario, BaseUtil base) throws Exception {
        jobName = scenario.getName();
        browser = FrameworkProperties.getBrowser();
        base.driver = WebDriverFactory.getWebDriver(browser, jobName);
        base.driver.manage().window().maximize();
        info(jobName);
    }

    public void tearDown(Scenario scenario, BaseUtil base) throws Exception {
        String sessionId = ((RemoteWebDriver) base.driver).getSessionId().toString();

        if (scenario.isFailed()) {
            byte[] screenshot = getScreenshot(base.driver);
            scenario.embed(screenshot, "image/png");
        }

        info("Test-Case:" + jobName);
        info("SessionId:" + sessionId);
        info("Browser:" + browser);
        info("Status:" + scenario.getStatus());

        base.driver.quit();


    }

    private byte[] getScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
