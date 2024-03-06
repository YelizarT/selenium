import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedFrame {

    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/nestedframes");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void nestedFrameTest() {
        driver.switchTo().frame("frame1");
        WebElement header = driver.findElement(By.tagName("body"));
        assertEquals("Parent frame", header.getText());
        //check text "Child Iframe"
        //WebElement childFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(0);
        //driver.switchTo().frame(childFrame);
        WebElement childHeader = driver.findElement(By.tagName("p"));
        assertEquals("Child Iframe", childHeader.getText());

    }
}
