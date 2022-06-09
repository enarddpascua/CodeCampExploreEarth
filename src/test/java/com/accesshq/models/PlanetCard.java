package com.accesshq.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class PlanetCard {

    WebElement planetElement;

    public PlanetCard(WebElement planetElement){
        this.planetElement = planetElement;
    }

    public String getPlanetName(){
        return planetElement.findElement(By.className("name")).getText().toLowerCase(Locale.ROOT);
    }

    public void clickExplore(){
        planetElement.findElement(By.tagName("button")).click();
    }

    public long getDistance(){
        return Long.parseLong(planetElement.findElement(By.className("distance")).
                getText().replaceAll("\\D", ""));
    }

    public int getRadius() {
        return Integer.parseInt(planetElement.findElement(By.className("radius")).
                getText().replaceAll("\\D", ""));
    }
}
