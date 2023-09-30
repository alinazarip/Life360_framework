package life360.step_definition;

import io.cucumber.java.*;
import life360.utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //import the @Before coming from io.cucumber .java because it will specifically create structure for the hooks class
    // @before method from Junit works as a TestNG @BeforeMethod
    @Before
    public void setupMethod() {
        System.out.println("----> @Before: RUNNING BEFORE EACH SCENARIO");
    }

    @After
    public void teardownMethod(Scenario scenario) {
        //we use byte because developers of cucumber wrote this line
        if(scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        System.out.println("----> @After: RUNNING EACH SCENARIO");
        Driver.closeDriver();}

    @BeforeStep
    public void setupStep() {
        System.out.println("---> @BeforeSTEP: Running before each step!");

    }
    @AfterStep
    public void teardownStep(){

        System.out.println("---> @AfterSTEP: Running after each step!");

    }



}
