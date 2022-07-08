package com.example.application;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.LoggerFactory;

public class MyIT {

    @Rule
    public TestName name = new TestName();

    @Test
    public void test1() throws Exception {
        test();
    }

    @Test
    public void test2() throws Exception {
        test();
    }

    @Test
    public void test3() throws Exception {
        test();
    }

    private void test() throws Exception {
        MutableCapabilities cap = new ChromeOptions();
        Map<String, Object> sauceOptions = new HashMap<>();

        sauceOptions.put("name", name.getMethodName());
        sauceOptions.put("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.put("access_key", System.getenv("SAUCE_ACCESS_KEY"));
        String tunnelId = System.getenv("SAUCE_TUNNEL_ID");
        if (tunnelId != null) {
            sauceOptions.put("tunnelIdentifier", tunnelId);
        }

        cap.setCapability("sauce:options", sauceOptions);

        RemoteWebDriver driver = new RemoteWebDriver(new URL("https://ondemand.saucelabs.com/wd/hub"), cap);

        log("Test " + name.getMethodName() + " starting");
        driver.get("http://localhost:8080/");
        log("Test " + name.getMethodName() + " waiting");
        // Thread.sleep(30000);
        log("Test " + name.getMethodName() + " waited");
        WebElement button = driver.findElement(By.tagName("button"));
        Assert.assertEquals("a button", button.getText());
        log("Test " + name.getMethodName() + " done");

    }

    private void log(String string) {
        LoggerFactory.getLogger(getClass()).info(string);
    }

}
