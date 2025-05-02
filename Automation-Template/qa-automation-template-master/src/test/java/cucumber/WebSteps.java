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
import org.apache.commons.lang3.RandomStringUtils;
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
import java.util.UUID;

import static dataProviders.configFileReader.getPropertyValue;
import static dataProviders.datasetFileReader.getDatasetValue;
import static dataProviders.repositoryFileReader.constructElement;
import static dataProviders.repositoryFileReader.findElementRepo;
import static org.junit.Assert.assertEquals;

public class WebSteps {

    WebDriver driver;
    private String randomEmpName;
    private String randomUserName;
    private String randomName;
    private String generatedNumber;
    private String randomEmail;
    private String generatedPassword;

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

    public void pressDownArrowAndEnter(WebDriver driver) {
        // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Press the down arrow key and then the enter key
        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
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

    @When("I clear text  {string}")
    public void Icleartext(String locator) {
        By element = constructElement(findElementRepo(locator));
        WebElement inputElement = driver.findElement(element);
        inputElement.clear();
    }

    @And("I clear textbox {string}")
    public void iClearTextbox(String locator) {
        By element = constructElement(findElementRepo(locator));
        WebElement inputElement = driver.findElement(element);
        inputElement.click(); // Ensure focus
        inputElement.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);
    }

    @And("I Scroll {string}")
    public void iScroll(String locator) {
        By elementLocator = constructElement(findElementRepo(locator));
        WebElement element = driver.findElement(elementLocator);
        if (element != null) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } else {
            System.out.println("Element not found or could not be scrolled into view.");
        }
    }

    @And("I hard click {string}")
    public void i_hard_click(String locator) {
        By elementLocator = constructElement(findElementRepo(locator));
        WebElement element = driver.findElement(elementLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public static int generateRandom10DigitInteger() {
        Random random = new Random();
        // Generate a random number between 1,000,000,000 and 9,999,999,999
        int randomNumber = random.nextInt(9_000_000) + 1_000_000;
        return randomNumber;
    }

    @And("I use random number to the {string}")
    public void i_use_random_number_to_the(String locator) {
        int randomNumber = generateRandom10DigitInteger();
        By element = constructElement(findElementRepo(locator));
        driver.findElement(element).sendKeys(String.valueOf(randomNumber));
    }

    @And("Scroll down")
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,950)", "");

    }

    @And("I Scroll down to the element {string}")
    public void iScrollDownToTheElement(String locator) {
        By element = constructElement(findElementRepo(locator));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    @And("I generate a random name to the {string}")
    public void i_generate_a_random_name(String parameterName) {
        // Generate a random name using Apache Commons Lang
        randomName = RandomStringUtils.randomAlphabetic(8);
        System.out.println("Generated Random Name: " + randomName);
        By element = constructElement(findElementRepo(parameterName));
        driver.findElement(element).sendKeys(String.valueOf(randomName));
    }

    @Given("I generate a random mobile number to the {string}")
    public void iGenerateARandomMobileNumber(String p_number) {
        Random rand = new Random();
        int suffix = 10000000 + rand.nextInt(90000000); // 8 digits
        generatedNumber = "07" + suffix; // total 10 digits
        System.out.println("Generated Mobile Number: " + generatedNumber);

        By element = constructElement(findElementRepo(p_number));
        driver.findElement(element).sendKeys(generatedNumber);
    }


    @Given("I generate a random email address to the {string}")
    public void iGenerateARandomEmailAddress(String random_Mail) {
        randomEmail = "user" + UUID.randomUUID().toString() + "@example.com";
        System.out.println("Generated Email: " + randomEmail);
        By element = constructElement(findElementRepo(random_Mail));
        driver.findElement(element).sendKeys(String.valueOf(randomEmail));
    }

    @Given("I generate a random password to the {string}")
    public void i_generate_a_random_password(String pw) {
        generatedPassword = generateRandomPassword(10); // Generate a 10-character password
        System.out.println("Generated Password: " + generatedPassword);
        By element = constructElement(findElementRepo(pw));
        driver.findElement(element).sendKeys(String.valueOf(generatedPassword));

    }

    private String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }

        return password.toString();
    }

    @When("I press the down arrow key and then enter")
    public void i_press_down_arrow_and_enter() {
        pressDownArrowAndEnter(driver);
    }

    @When("I press the up arrow key")
    public void i_press_up_arrow_key() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).perform();
    }

    @When("I press the Enter key")
    public void i_press_enter_key() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    @When("I press the up arrow key a random number of times")
    public void i_press_up_arrow_key_random_times() {
        Random random = new Random();
        int times = random.nextInt(50) + 1; // Generates a number between 1 and 50
        System.out.println("Pressing UP arrow " + times + " times");

        Actions actions = new Actions(driver);
        for (int i = 0; i < times; i++) {
            actions.sendKeys(Keys.ARROW_UP).perform();
        }
    }










}

