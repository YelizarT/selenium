import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class PhotoManager {

    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void moveAllPhotosToTrash() throws InterruptedException {
        WebElement Frame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(Frame);
        List<WebElement> photos = driver.findElements(By.className("ui-draggable"));
        WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));
        Actions actions = new Actions(driver);
        for (WebElement onePhoto: photos){
            actions.dragAndDrop(onePhoto, trash).perform();
        }
        sleep(4000);

        for (WebElement photo :photos) {
            sleep(4000);
            WebElement recycle = driver.findElement(By.cssSelector("[title='Recycle this image']"));
            actions.moveToElement(photo).moveToElement(recycle).click().build().perform();
        }
//
//        WebElement recycleButton = driver.findElement(By.xpath("//*[@id=\"trash\"]/ul/li[1]/a[2]"));
//        recycleButton.click();
//
//        WebElement recycleButton4 = driver.findElement(By.xpath("//*[@id=\"trash\"]/ul/li[2]/a[2]"));
//        recycleButton4.click();
//
//        WebElement recycleButton2 = driver.findElement(By.xpath("//*[@id=\"trash\"]/ul/li[3]/a[2]"));
//        recycleButton2.click();
//
//        WebElement recycleButton3 = driver.findElement(By.xpath("//*[@id=\"trash\"]/ul/li[4]/a[2]"));
//        recycleButton3.click();
//        sleep(4000);
    }
}
