package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/",
        glue = "Steps",
        dryRun = false,
        tags = "@tc1103",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
)
public class SmokeRunner {
}