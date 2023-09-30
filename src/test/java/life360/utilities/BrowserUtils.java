package life360.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    public static void sleep(int second) {

        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(String expectedURL, String expectedTitle) {

        //Return and stores all window handles in a Set
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current IRL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedURL)) {
                break;
            }
        }

        // 5. Assert:TitleContains“Etsy”

        String actualTitle = Driver.getDriver().getTitle();


        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    public static void verifyTitle(String expectedTitle) {

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    public static void verifyTitleContains(String expectedInTitle) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    /*
    This method accepts WebElement target, and waits for the WebElement not to be displayed on the page
     */

    public static void waitForInvisibilityOf(WebElement target) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait condition
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    /*
    This method accepts String title, and waits for the Title to contain given String value
     */

    public static void waitForTitleContains(String title) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait condition
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static List<String> dropdownOptions_as_String(WebElement dropdownElement) {

        Select month = new Select(dropdownElement);

        //Storing all the actual options into a List of WebElement
        List<WebElement> actualMonth_WebElement = month.getOptions();

        //Creating an empty list of string to store Actual <options> as String
        List<String> actualMonth_as_String = new ArrayList<>();

        //Looping through the List<WebElement> getting all options texts, and storing them into List<String>
        for (WebElement each : actualMonth_WebElement) {

            actualMonth_as_String.add(each.getText());


        }
        return actualMonth_as_String;

    }

    public static void clickRadioButton(List<WebElement> radioButton,String attributeValue){

        for (WebElement each : radioButton) {
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }

        }


    }

}

