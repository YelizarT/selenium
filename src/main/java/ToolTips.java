import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToolTips {

    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/tool-tips");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void toolTipTest() throws InterruptedException {
        //Hover over "Hover me to see" button
        WebElement meToSeeButton = driver.findElement(By.id("toolTipButton"));
        Actions actions = new Actions(driver);
        actions.moveToElement(meToSeeButton).perform();
        //Check that tooltip has text "You hovered over the Button"
        WebElement toolTip = driver.findElement(By.className("tooltip-inner"));
        assertEquals("You hovered over the Button", toolTip.getText());

        WebElement inputField = driver.findElement(By.id("toolTipTextField"));
        actions.moveToElement(inputField).perform();
        sleep(5000);
        WebElement hooverText = driver.findElement(By.className("tooltip-inner"));
        sleep(5000);
        assertEquals("You hovered over the text field", hooverText.getText());
        sleep(5000);

        WebElement contrary = driver.findElement(By.cssSelector("#texToolTopContainer > a:nth-child(1)"));
        actions.moveToElement(contrary).perform();
        sleep(5000);
        WebElement linkText = driver.findElement(By.className("tooltip-inner"));
        assertEquals("You hovered over the Contrary", linkText.getText());
        sleep(5000);

        WebElement numbers = driver.findElement(By.cssSelector("#texToolTopContainer > a:nth-child(2)"));
        actions.moveToElement(numbers).perform();
        sleep(5000);
        WebElement linkNumbers = driver.findElement(By.className("tooltip-inner"));
        assertEquals("You hovered over the 1.10.32", linkNumbers.getText());
        sleep(5000);
    }
}
