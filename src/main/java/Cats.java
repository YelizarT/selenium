import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Cats {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://suninjuly.github.io/cats.html");
    }

    @Test
    public void headerTextTest(){
        WebElement header = driver.findElement(By.cssSelector("[class='jumbotron-heading']"));
        assertEquals("Dog memes", header.getText());
    }
    @Test
    public void timeFirstCatCardTest(){
        WebElement timeFirstCatCard = driver.findElement(By.xpath("//div[@class='col-sm-4'][1]//small"));
        assertEquals("9 mins", timeFirstCatCard.getText());
    }

    //check that "I love you so much" in name of last card

    @Test
    public void nameOfLastCatCardTest(){
        WebElement nameLastCard = driver.findElement(By.xpath("//div[@class=\"col-sm-4\"][6]//p"));
        assertEquals("I love you so much", nameLastCard.getText());
    }

    @Test
    public void catsAlbumTittleTest(){
        WebElement catsAlbumTittle = driver.findElement(By.tagName("strong"));
        assertTrue(catsAlbumTittle.isDisplayed());
    }

    //first cat card is displayed
    @Test
    public void firstCatCardIsDisplayed(){
        WebElement firstCard = driver.findElement(By.xpath("//*[@class=\"col-sm-4\"][1]"));
        assertTrue(firstCard.isDisplayed());
    }

    //check that 6 cards
    @Test
    public void checkCardQuantity(){
        List<WebElement> cards = driver.findElements(By.className("col-sm-4"));
        assertEquals(6, cards.size());
    }

    //check that 6 images are on the page
    @Test
    public void checkImagesQuantity(){
        List<WebElement> images = driver.findElements(By.tagName("img"));
    }
    //check that all cards are displayed
    @Test
    public void checkAllCardsAreDisplayed() {
        List<WebElement> cards = driver.findElements(By.className("col-sm-4"));
        /*for (int i=0; i<cards.size();i++){
            assertTrue(cards.get(i).isDisplayed());
        }*/
 /*       for (WebElement card: cards) {
            assertTrue(card.isDisplayed());
        }*/
        cards.forEach(card -> assertTrue(card.isDisplayed()));
    }

    //Check that all cards have no empty names
    @Test
    public void allCardsNamesAreNotEmpty(){
        List<WebElement> names = driver.findElements(By.tagName("p"));
        for (WebElement name: names) {
            assertFalse(name.getText().isEmpty());
        }
    }
}
