package com.accesshq.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Popup {
    WebDriver driver;

    public Popup(WebDriver driver){
        this.driver = driver;
    }

    public String getPopupMessage(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(p -> p.findElement(By.className("popup-message")).isDisplayed());
        return driver.findElement(By.className("snackbar")).getText();
    }
}
