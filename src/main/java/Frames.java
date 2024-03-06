import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Frames {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void frameTest() {
        driver.switchTo().frame("frame1");
        WebElement header = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", header.getText());

        //check that second header in small window has text "This is a sample page"
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        WebElement header2 = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", header2.getText());
    }
}
