import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Registration {

    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/registration1.html");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successRegistrationOnlyRequiredFields() throws InterruptedException {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");
        //Input last name and email values
        WebElement lastNameInputFiled = driver.findElement(By.cssSelector("[placeholder=\"Input your last name\"]"));
        lastNameInputFiled.sendKeys("sdsd");

        WebElement emailInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your email\"]"));
        emailInputField.sendKeys("sdfdsf");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
       // assert that registration is successful
        sleep(5000);
        WebElement congratsHeader = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!",
                congratsHeader.getText());
    }
    @Test
    public void successRegistrationWithAllFields(){
        WebElement firstNameInputField = driver.findElement(
                By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");
        WebElement lastNameInputFiled = driver.findElement(
                By.cssSelector("[placeholder=\"Input your last name\"]"));
        lastNameInputFiled.sendKeys("sdsd");
        WebElement emailInputField = driver.findElement(
                By.cssSelector("[placeholder=\"Input your email\"]"));
        emailInputField.sendKeys("sdfdsf");
        WebElement phoneInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your phone:\"]"));
        phoneInputField.sendKeys("22345678");
        WebElement addressInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your address:\"]"));
        addressInputField.sendKeys("shgdfcgjdskc");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement congratsHeader = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!",
                congratsHeader.getText());
     /*   assertEquals("https://suninjuly.github.io/registration_result.html?",
                driver.getCurrentUrl());*/
        assertTrue(driver.getCurrentUrl().contains("registration_result"));
    }

    @Test
    public void registrationWithoutFirstName(){
        WebElement lastNameInputFiled = driver.findElement(
                By.cssSelector("[placeholder=\"Input your last name\"]"));
        lastNameInputFiled.sendKeys("sdsd");
        WebElement emailInputField = driver.findElement(
                By.cssSelector("[placeholder=\"Input your email\"]"));
        emailInputField.sendKeys("sdfdsf");
        WebElement phoneInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your phone:\"]"));
        phoneInputField.sendKeys("22345678");
        WebElement addressInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your address:\"]"));
        addressInputField.sendKeys("shgdfcgjdskc");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        assertTrue(driver.getCurrentUrl().contains("registration1"));
    }



}
