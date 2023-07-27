package Pages;

import framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    //Chicago
    WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(20));
    By searchBoxXpath= new By.ByXPath("(//input[@id='search-box-input'])[1]");
    By searchButtonXpath= new By.ByXPath("(//button[@aria-label='submit search'])[1]");
    By searchResultsLabel = new By.ByXPath("//h1[.='Chicago Homes for Sale']");
    public void SearchCity(String cityName){
        WebElement searchBox = DriverManager.driver.findElement(searchBoxXpath);
        searchBox.sendKeys(cityName);

    }
    public void clickSearchButton(){
        WebElement searchButton = DriverManager.driver.findElement(searchButtonXpath);
        searchButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchResultsLabel));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
