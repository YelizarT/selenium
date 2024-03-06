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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Allerts {

    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstAlert() {
        //CLICK the first button "Click me"
        //Check that text of alert "You clicked a button" is displayed
        WebElement clickMeButton1 = driver.findElement(By.id("alertButton"));
        clickMeButton1.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("You clicked a button", alert.getText());
    }

    @Test
    public void secondAlert() {

        WebElement clickMeButton2 = driver.findElement(By.id("timerAlertButton"));
        clickMeButton2.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("This alert appeared after 5 seconds", alert.getText());
    }

    @Test
    public void alertConfirm() {

        WebElement clickMeButton3 = driver.findElement(By.id("confirmButton"));
        clickMeButton3.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        WebElement confirmResult = driver.findElement(By.id("confirmResult"));
        assertEquals("You selected Ok", confirmResult.getText());
    }

    @Test
    public void alertCancel() {
        WebElement clickMeButton3 = driver.findElement(By.id("confirmButton"));
        clickMeButton3.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        WebElement confirmResult = driver.findElement(By.id("confirmResult"));
        assertEquals("You selected Cancel", confirmResult.getText());
    }

    public void alertInput() {
        String name = "John"; // dlja onogo raza smenitj
        WebElement fourthButton = driver.findElement(By.id("promtButton")); // #promtButton
        fourthButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));// 10 sek zdjom
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(name); // alert.sendKeys("Kamilla")
        alert.accept();
        WebElement promptResult = driver.findElement(By.id("promptResult"));
        assertEquals("You entered " + name, promptResult.getText());
    }
}


