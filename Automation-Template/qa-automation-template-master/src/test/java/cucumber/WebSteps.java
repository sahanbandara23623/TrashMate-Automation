package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static dataProviders.configFileReader.getPropertyValue;
import static dataProviders.datasetFileReader.getDatasetValue;
import static dataProviders.repositoryFileReader.constructElement;
import static dataProviders.repositoryFileReader.findElementRepo;
import static org.junit.Assert.assertEquals;

public class WebSteps {

    WebDriver driver;
    private String randomEmpName;
    private String randomUserName;

    private Scenario scenario;


    @Before
    public void setup(Scenario scenario){
        String browser = getPropertyValue("browser");
        switch (browser){
            case "chrome" -> {
                driver = WebDriverManager.chromedriver().create();
            }
            case "firefox" -> {
                driver = WebDriverManager.firefoxdriver().create();
            }
            case "edge" -> {
                driver = WebDriverManager.edgedriver().create();
            }
            default -> throw new RuntimeException("Browser not supported");
        }
        // Maximize the browser window
        driver.manage().window().maximize();

        scenario.log("Scenario executed on " + browser + " browser");
        this.scenario = scenario;
    }

    @After
    public void afterScenario (Scenario scenario) throws IOException {
        //Take Screenshot and attached to the report
        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "Failed step screenshot");
        }

            driver.quit();
    }

    @Given("I have opened the system")
    public void iHaveOpenedTheSystem() {
        driver.get(getPropertyValue("baseURL"));
    }


    @And("I type {string} to the {string}")
    public void iTypeToThe(String text, String locator) {
        By element = constructElement(findElementRepo(locator));
        driver.findElement(element).sendKeys(text);
    }

    @And("I click on {string}")
    public void iClickOn(String locator) {
        By element = constructElement(findElementRepo(locator));
        driver.findElement(element).click();
    }

    @Then("I see the exact {string} display on {string}")
    public void iSeeTheExactDisplayOn(String text, String locator) {
        By element = constructElement(findElementRepo(locator));
        //get value from dataset
        String value = getDatasetValue(text);
        scenario.log(text + " : " + value);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(50000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        assertEquals("Assert field text is not match", value, driver.findElement(element).getText());
    }

    @And("I wait few seconds")
    public void iWaitFewSeconds() throws InterruptedException {
        Thread.sleep(3000);
    }

    @When("I press the down arrow and then enter key")
    public void i_press_down_arrow_and_enter() {
        // Create an instance of Actions
        Actions actions = new Actions(driver);

        // Perform the keyboard actions: press down arrow once, then press Enter
        actions.sendKeys(org.openqa.selenium.Keys.ARROW_DOWN)
                .sendKeys(org.openqa.selenium.Keys.ENTER)
                .perform();
    }

    @Given("I generate a random UserName to the {string}")
    public void iGenerateARandomUserName(String UserName) {
        List<String> empNames = Arrays.asList(
                "Sahan23623",
                "Vidura23623",
                "Malith23623",
                "Vinnath23623",
                "Venura23623",
                "Beesara23623",
                "Vidath23623",
                "Haritha23623",
                "Pramith23623",
                "Savindu23623"
        );

        Random random = new Random();
        int index = random.nextInt(empNames.size());
        randomUserName = empNames.get(index);
        By element = constructElement(findElementRepo(UserName));
        driver.findElement(element).sendKeys(String.valueOf(randomUserName));
    }
}

