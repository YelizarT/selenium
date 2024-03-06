import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Hover {

    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();
        driver.get("https://crossbrowsertesting.github.io/hover-menu.html");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void hoverTest() throws InterruptedException {
        WebElement dropdown = driver
                .findElement(By.xpath("//li[@class=\"dropdown\"]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.)
        sleep(5000);
        WebElement secondaryMenu = driver
                .findElement(By.xpath("//li[@class=\"secondary-dropdown\"]/a"));
        actions.moveToElement(secondaryMenu).perform();
        sleep(3000);
        //Push the "Secondary Action" button
        WebElement secondaryAction = driver
                .findElement(By.xpath("//ul[@class=\"dropdown-menu secondary\"]//li/a"));
                secondaryAction.click();
                sleep(3000);
        //Check that "Secondary Page" is displayed
        WebElement secondaryPage = driver.findElement(By.xpath("//div[@class=\"jumbotron secondary-clicked\"]/h1"));
        assertEquals("Secondary Page",
                secondaryPage.getText());

        WebElement secondaryActionClicked = driver.findElement(By.xpath("//div[@class=\"jumbotron secondary-clicked\"]/p[1]"));
        assertEquals("Secondary action in the menu was clicked successfully!",
                secondaryActionClicked.getText());
    }
}
