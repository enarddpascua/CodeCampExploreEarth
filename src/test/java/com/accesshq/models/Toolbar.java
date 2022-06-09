package com.accesshq.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Toolbar {
    WebDriver driver;

    public Toolbar(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getUser(){
        return driver.findElement(By.cssSelector("[aria-label=users]"));
    }

    public WebElement getHome(){
        return driver.findElement(By.cssSelector("[aria-label=home]"));
    }

    public WebElement getForms(){
        return driver.findElement(By.cssSelector("[aria-label=forms]"));
    }

    public WebElement getPlanets(){
        return driver.findElement(By.cssSelector("[aria-label=planets]"));
    }

    public void clickUser(){
        getUser().click();
    }

    public void goToHome(){
        getHome().click();
    }

    public void goToForms(){
        getForms().click();
    }

    public void goToPlanets(){
        getPlanets().click();
    }
}
