package com.accesshq.models;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PlanetsPage {
    private final WebDriver driver;

    public PlanetsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ArrayList<PlanetCard> getAllPlanets(){
        var result = new ArrayList<PlanetCard>();
        for(WebElement p : driver.findElements(By.className("planet"))){
            result.add(new PlanetCard(p));
        }
        return result;
    }

    public PlanetCard getPlanet(Predicate<PlanetCard> logic) throws NotFoundException {
        for(PlanetCard p: getAllPlanets()){
            if(logic.test(p)){
                return p;
            }
        }
        throw new NotFoundException("Planet not found");
    }

}
