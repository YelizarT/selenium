import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;
import java.time.Duration;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwitchToTab {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();
        driver.get("http://suninjuly.github.io/redirect_accept.html");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    public double funcCalc(double x){
        return log(abs(12*sin(x)));
    }
    @Test
    public void switchToTabTest() throws InterruptedException {
        WebElement redirectButton = driver.findElement(By.className("btn-primary"));
        redirectButton.click();
        //sleep(10000);
        System.out.println(driver.getWindowHandles());
        System.out.println(driver.getWindowHandle());
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //math calc and enter answer to the input field
        //push Submit button
        //assert that alert has text "Congrats!..."
        WebElement x = driver.findElement(By.id("input_value"));
        System.out.println(x.getText());
        double xValue = parseDouble(x.getText());
        //System.out.println(xValue);
        double result = funcCalc(xValue);
        WebElement answerInputField =
                driver.findElement(By.id("answer"));
        answerInputField.sendKeys(String.valueOf(result));
        WebElement submitButton =
                driver.findElement(By.tagName("button"));
        submitButton.click();
        //check that alert has text "Congrats, you've passed the task!"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

    }
}
