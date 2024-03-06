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

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathCalc {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/math.html");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    public double funcCalc(double x){
        return log(abs(12*sin(x)));
    }

    @Test
    public void validAnswer() throws InterruptedException {
        WebElement x = driver.findElement(By.id("input_value"));
        System.out.println(x.getText());
        double xValue = parseDouble(x.getText());
        System.out.println(xValue);
        double result = funcCalc(xValue);
        WebElement answerInputField =
                driver.findElement(By.id("answer"));
        answerInputField.sendKeys(String.valueOf(result));
        sleep(5000);

        //check checkbox I'm the robot
        WebElement robotCheckbox =
                driver.findElement(By.id("robotCheckbox"));
        robotCheckbox.click();
        //choose Robots rule
        WebElement robotsRule =
                driver.findElement(By.id("robotsRule"));
        robotsRule.click();
        //push Submit button
        WebElement submitButton =
                driver.findElement(By.tagName("button"));
        submitButton.click();
        //check that alert has text "Congrats, you've passed the task!"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

    }

}
