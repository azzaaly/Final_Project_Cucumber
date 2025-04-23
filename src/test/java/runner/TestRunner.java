package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/Features",glue = "stepdef",plugin = {"pretty","html:target/reports/report.html"})

public class TestRunner extends AbstractTestNGCucumberTests{
}
