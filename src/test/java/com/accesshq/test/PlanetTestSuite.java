package com.accesshq.test;

import com.accesshq.models.PlanetsPage;
import com.accesshq.models.Popup;
import com.accesshq.models.Toolbar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlanetTestSuite {

    WebDriver driver;

    @BeforeEach
    public void beforeEachTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }

    @Test
    public void explorePlanetTest() throws NotFoundException {
        // Arrange
        new Toolbar(driver).goToPlanets();

        // Act
        new PlanetsPage(driver).getPlanet(p -> p.getPlanetName().
                equalsIgnoreCase("Earth")).clickExplore();

        // Assert
        Assertions.assertEquals("Exploring Earth", new Popup(driver).getPopupMessage());
    }

    @Test
    public void exploreDistance(){
        // Arrange
        new Toolbar(driver).goToPlanets();

        // Act
        new PlanetsPage(driver).getPlanet(p -> p.getDistance() == 227900000).clickExplore();

        // Assert
        Assertions.assertEquals("Exploring Mars", new Popup(driver).getPopupMessage());
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
