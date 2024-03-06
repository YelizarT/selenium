import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginForm {

    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();
        driver.get("https://crossbrowsertesting.github.io/login-form.html");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successLoginValidData(){
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tester@crossbrowsertesting.com");

        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("test123");

        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();

        WebElement congratsHeader = driver.findElement(By.id("logged-in-message"));
        assertEquals("Welcome tester@crossbrowsertesting.com",
                congratsHeader.getText());

        assertTrue(driver.getCurrentUrl().contains("registration_result"));


    }
}
