package co.com.sofka.runner.opensource;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html"},
        features = {"src/test/resources/features/webui/opensource/moduloEmployee.feature"},
        glue = {"co.com.sofka.stepdefinition.opensource.opt1"},
        tags = "not @ignore"
)
public class OpenSourceCucumberOpt1Test {
}
