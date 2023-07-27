package Pages;

import dev.failsafe.internal.util.Assert;
import framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {
    WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(60));
    By allFiltersXpath = new By.ByXPath("//div[@aria-label='All filters']");
    By priceFilerXPath = new By.ByXPath("//button[@data-rf-test-id='apply-search-options']");

    By minPriceXpath = new By.ByXPath("//input[@placeholder='Enter min']");

    By maxPriceXpath = new By.ByXPath("//input[@placeholder='Enter max']");
    By searchResultPricesXPath = new By.ByXPath("//td[contains(@class,'col_price')]");
    By tableViewXPath = new By.ByXPath("//span[@data-rf-test-name='tableOption']");

    public void clickAllFilters() {
        WebElement filters = DriverManager.driver.findElement(allFiltersXpath);
        filters.click();


    }

    public void applyMinFilter(String minValue) {
        WebElement minFilter = DriverManager.driver.findElement(minPriceXpath);
        minFilter.sendKeys(minValue);

    }

    public void applyMaxFilter(String maxValue) {
        WebElement maxFilter = DriverManager.driver.findElement(maxPriceXpath);
        maxFilter.sendKeys(maxValue);


    }

    public void applyPriceFilter() {
        WebElement element = DriverManager.driver.findElement(priceFilerXPath);
        element.click();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void verifyPriceRange(Integer noOfpages, Integer minPrice, Integer maxPrice) {
        WebElement tableView = DriverManager.driver.findElement(tableViewXPath);
        tableView.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int page = 1; page <= noOfpages; page++) {
            List<WebElement> priceElementList = DriverManager.driver.findElements(searchResultPricesXPath);
            System.out.println("No. of Homes on Page " + page + " is " + +priceElementList.size());
            for (WebElement e : priceElementList
            ) {
                Integer homePrice = Integer.valueOf(e.getText().replace("$", "").replace(",", ""));
                Assert.isTrue(minPrice <= homePrice, homePrice + " is below " + minPrice);

                Assert.isTrue(homePrice <= maxPrice, homePrice + " is greater than " + maxPrice);
                System.out.println(homePrice + " is with in the range of  " + minPrice + " and " + maxPrice);
            }

            WebElement nextPage = DriverManager.driver.findElement(By.xpath("//a[.='" + (page + 1) + "']"));
            nextPage.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }


}
