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

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UploadFile {

    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://suninjuly.github.io/file_input.html");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void uploadFile() throws InterruptedException {
        WebElement firstNameInputField=driver.findElement(By.cssSelector("[placeholder='Enter first name']"));
        firstNameInputField.sendKeys("Yelizar");
        WebElement lastNameInputField=driver.findElement(By.cssSelector("[placeholder='Enter last name']"));
        lastNameInputField.sendKeys("Tatsenko");
        WebElement EmailInputField=driver.findElement(By.cssSelector("[placeholder='Enter email']"));
        EmailInputField.sendKeys("test1@gmail.com");
        //sleep(2000);
        WebElement uploadFile = driver.findElement(By.id("file"));
        uploadFile.sendKeys("C:\\Users\\Zar\\Documents\\QApro\\Unit_tests\\textfile.txt");
        //Push Submit button
        WebElement submitButton = driver.findElement(By.cssSelector("[class='btn btn-primary']"));
        submitButton.click();
        //Alert has text "Congrats, you've passed the task!"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }
}
