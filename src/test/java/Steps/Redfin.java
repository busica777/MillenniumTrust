package Steps;

import Pages.HomePage;
import Pages.SearchResultsPage;
import framework.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Redfin {
    @When("user go to provided URL {string}")
    public void user_go_to_provided_url(String URL) {
        // Write code here that turns the phrase above into concrete actions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DriverManager.driver = new ChromeDriver(options);
        DriverManager.driver.navigate().to(URL);
        DriverManager.driver.manage().window().maximize();

    }

    @When("user types a large city name {string}")
    public void user_types_a_large_city_name(String cityName) {
        // Write code here that turns the phrase above into concrete actions
//chicago
        HomePage homePage = new HomePage();
        homePage.SearchCity(cityName);
    }

    @Then("user clicks on the search button")
    public void user_clicks_on_the_search_button() {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage();
        homePage.clickSearchButton();
    }

    @Then("User apply the price filter with values {string} and {string}")
    public void user_apply_the_price_filter_with_values_and(String minValue, String maxValue) {
        // Write code here that turns the phrase above into concrete actions
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.clickAllFilters();
        searchResultsPage.applyMinFilter(minValue);
        searchResultsPage.applyMaxFilter(maxValue);
        searchResultsPage.applyPriceFilter();
    }

    @Then("verify the results within the specified range on the first {int} pages {string} and {string}")
    public void verify_the_results_within_the_specified_range_on_the_first_pages(Integer noOfpages, String minPrice, String maxPrice) {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.verifyPriceRange(noOfpages,Integer.valueOf(minPrice),Integer.valueOf(maxPrice));

    }
}
