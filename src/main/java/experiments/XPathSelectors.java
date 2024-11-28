package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XPathSelectors
{
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorRadioButtonPage()
    {
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        hideBanner();
        hideFooter();

        WebElement rbtnImp = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        rbtnImp.click();

        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

    @Test
    public void selectorTextBox()
    {
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        hideBanner();
        hideFooter();

        WebElement textB = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        textB.sendKeys("Tanya");

        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        WebElement email = driver.findElement(By.xpath("//form/div[@id='userEmail-wrapper']//input"));
        email.sendKeys("tns@gmail.com");

        WebElement text = driver.findElement(By.xpath("//*[text()='Current Address']"));
        System.out.println(text.getText());

        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        WebElement field = driver.findElement(By.xpath("//*[text()='Current Address']/../..//textarea"));
        field.sendKeys("kdkskwklwllallsll");

        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        WebElement PerAdd = driver.findElement(By.xpath("//div[@id='permanentAddress-wrapper']//textarea"));
        PerAdd.sendKeys("jdkwlolllelwl");

        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        WebElement btnSub = driver.findElement(By.xpath("//button[text()='Submit']"));
        btnSub.click();

        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        WebElement output = driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println(output.getText());

       driver.quit();
    }

    private void hideBanner()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");
    }

    private void hideFooter()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}
