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

import static java.lang.Integer.parseInt;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropDown {

    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/selects2.html");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void dropDownTest(){
        WebElement num1 = driver.findElement(By.id("num1"));
        WebElement num2 = driver.findElement(By.id("num2"));

        int sum = parseInt(num1.getText()) + parseInt(num2.getText());
        //System.out.println(num1.getText() + ", " + num2.getText());
        //System.out.println(sum);
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        dropDown.click();
        WebElement answerOption = driver.findElement(By.cssSelector("[value='" + sum + "']"));
        answerOption.click();
        System.out.println("[value='" + sum + "']");
        //check that alert has text "Congrats, you've passed the task!"
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));


    }

}
