package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsHomePage(){
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        WebElement imgTools = driver.findElement(By.cssSelector("img[src='/images/Toolsqa.jpg']"));
        System.out.println(imgTools.getTagName());
        WebElement divElements = driver.findElement(By.cssSelector(".card.mt-4.top-card"));
        divElements.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

    @Test
    public void selectorsElementsPage(){
        driver.get("https://demoqa.com/elements");
        driver.manage().window().maximize();
        WebElement textBox = driver.findElement(By.id("item-0"));
        System.out.println(textBox.getAttribute("class"));
        WebElement checkBox = driver.findElement(By.cssSelector("li[id='item-1']"));
        checkBox.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
