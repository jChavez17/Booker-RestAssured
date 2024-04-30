package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/UnHappyPath.feature",
        glue = {"stepdefinitions"},
        plugin = {"pretty"}
)
public class RunCucumberTest {
    // Esta clase inicia la ejecución de las pruebas Cucumber
}