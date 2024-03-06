import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDo {

    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();
        driver.get("https://crossbrowsertesting.github.io/todo-app.html");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void crossLineAfterCheck(){

        WebElement firstCheckBox = driver.findElement(By.cssSelector("[name=\"todo-1\"]"));
        firstCheckBox.click();
        WebElement firstLineText = driver.findElement(By.cssSelector("[name=\"todo-1\"]~span"));
        assertEquals("done-true", firstLineText.getAttribute("class"));
    }
    @Test
    public void decrossingFirstLineAfterUncheckBox(){
        WebElement firstCheckBox = driver.findElement(By.cssSelector("[name=\"todo-1\"]"));
        firstCheckBox.click();
        WebElement firstLineText = driver.findElement(By.cssSelector("[name=\"todo-1\"]~span"));
        assertEquals("done-true", firstLineText.getAttribute("class"));
        firstCheckBox.click();
        assertEquals("done-false", firstLineText.getAttribute("class"));
    }
    @Test
    public void quantityOfRemainingTasksIsCorrect() throws InterruptedException {
        //проверяем, что коллич. элементов на странице соответствует указанному числу
        WebElement addTaskButton = driver.findElement(By.id("addbutton"));
        addTaskButton.click();
        addTaskButton.click();
        addTaskButton.click();
        addTaskButton.click();
        addTaskButton.click();
        addTaskButton.click();
        addTaskButton.click();
        addTaskButton.click();
        sleep(2000);
        List<WebElement> tasks = driver.findElements(By.cssSelector("[type=\"checkbox\"]"));
        System.out.println(tasks.size());
        WebElement quantityTasks = driver.findElement(By.className("ng-binding"));
        String quantityTasksText = quantityTasks.getText();
        int indexRemaining = quantityTasksText.indexOf(" remaining");
        int indexOf = quantityTasksText.indexOf("of");
        System.out.println(quantityTasks.getText().substring(indexOf+3, indexRemaining));
    }
    @Test
    public void quantityOfDoneFalseTasks() throws InterruptedException {
        //Check 2 checkbox
        //Check that quantity of tasks with class done-false equals to quantity of tasks in counter
        WebElement addTaskButton = driver.findElement(By.id("addbutton"));
        List<WebElement> tasks = driver.findElements(By.cssSelector("[type=\"checkbox\"]"));
        System.out.println(tasks.size());
        WebElement quantityTasks = driver.findElement(By.className("ng-binding"));
        String quantityTasksText = quantityTasks.getText();
        int indexRemaining = quantityTasksText.indexOf(" remaining");
        int indexOf = quantityTasksText.indexOf("of");
        System.out.println(quantityTasks.getText().substring(indexOf, indexRemaining));


    }
}
