import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeForm {

    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void allValiData() throws InterruptedException {

        WebElement firstNameInputField=driver.findElement(By.id("firstName"));
        firstNameInputField.sendKeys("Yelizar");
        WebElement lastNameInputField=driver.findElement(By.id("lastName"));
        lastNameInputField.sendKeys("Tatsenko");
        WebElement EmailInputField=driver.findElement(By.cssSelector("[placeholder=\"name@example.com\"]"));
        EmailInputField.sendKeys("test1@gmail.com");
        WebElement genderRadioButton=driver.findElement(By.cssSelector("[class=\"custom-control-label\"]"));
        genderRadioButton.click();
        WebElement mobileNumberButton=driver.findElement(By.cssSelector("[placeholder=\"Mobile Number\"]"));
        mobileNumberButton.sendKeys("+498787878787");
        WebElement dateOfBirthButton=driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthButton.sendKeys("19840329");


        WebElement subjectsField=driver.findElement(By.id("subjectsContainer"));
        //subjectsField.sendKeys("sdgbsbsbsdfb");

        sleep(3000);
        WebElement hobbiesButton1=driver.findElement(By.id("hobbies-checkbox-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hobbiesButton1);
        //hobbiesButton1.click();

        WebElement hobbiesButton2=driver.findElement(By.id("hobbies-checkbox-3"));
        //hobbiesButton2.click();
        WebElement selectPictureButton=driver.findElement(By.id("uploadPicture"));
        selectPictureButton.sendKeys("C:\\Users\\Zar\\Desktop\\Мемы\\th.jfif");

        WebElement currentAddressField=driver.findElement(By.cssSelector("[placeholder=\"Current Address\"]"));
        currentAddressField.sendKeys("London");

        sleep(5000);

        WebElement curAddress = driver.findElement(By.id("currentAddress-wrapper"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", curAddress);

        WebElement stateDropDown=driver.findElement(By.id("state"));
        stateDropDown.click();
        //WebElement answerOption = driver.findElement(By.id("react-select-3-input"));
        //answerOption.click();
        //WebElement cityDropDown=driver.findElement(By.id("city"));
        //cityDropDown.click();
        //WebElement answerOption = driver.findElement(By.id("react-select-4-input"));

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        //Check that submitting was successful
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Thanks for submitting the form"));

    }
}
