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

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HugeForm {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();
        driver.get("http://suninjuly.github.io/huge_form.html");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void successRegistration() throws InterruptedException {
        List<WebElement> inputFields =
                driver.findElements(By.tagName("input"));
        //enter data to all input fields
        for (WebElement input: inputFields) {
            input.sendKeys("Hello");
        }
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
        //sleep(5000);

        //Congrats, you've passed the task!
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        //System.out.println(alert.getText());
        //check that alert has text "Congrats, you've passed the task!"
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

    }
}
