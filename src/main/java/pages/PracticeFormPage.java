package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class PracticeFormPage extends BasePage
{
    public PracticeFormPage(WebDriver driver)
    {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement name;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement email;

    @FindBy(xpath = "//input[@id='userNumber']")
    WebElement phone;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    WebElement fieldDateOfBirth;

    @FindBy(xpath = "//input[@id='subjectsInput']")
    WebElement fieldSubjects;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement checkSport;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement checkReading;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement checkMusic;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement address;

    @FindBy(xpath = "//input[@id='react-select-3-input']")
    WebElement selectState;

    @FindBy(xpath = "//input[@id='react-select-4-input']")
    WebElement selectCity;

    @FindBy(id = "submit")
    WebElement btnSubmit;


    public void typePracticeForm(Student student)
    {
        hideBanner();
        hideFooter();
        name.sendKeys(student.getName());
        lastName.sendKeys(student.getLastName());
        email.sendKeys(student.getEmail());
        typeGender(student.getGender());
        phone.sendKeys(student.getPhoneNumber());
        typeDateOfBirth(student.getDateOfBirth());
        typeSubjects(student.getSubjects());
        typeHobbies(student.getHobbies());
        address.sendKeys(student.getAddress());
        typeStateCity(student.getState(), student.getCity());
        btnSubmit.click();
    }

    private void typeStateCity(String state, String city)
    {
        selectState.sendKeys(state);
        selectState.sendKeys(Keys.ENTER);

        selectCity.sendKeys(city);
        selectCity.sendKeys(Keys.ENTER);
    }

    private void typeHobbies(List<Hobbies> hobbies)
    {
        for (Hobbies h: hobbies)
        {
            switch (h)
            {
                case MUSIC:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;

                case SPORTS:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;

                case READING:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
            }
        }
    }

    private void typeSubjects(String subjects)
    {
        fieldSubjects.click();
        String[] ar = subjects.split(",");
        for(String s: ar)
        {
            fieldSubjects.sendKeys(s);
            fieldSubjects.sendKeys(Keys.ENTER);
        }
    }

    private void typeDateOfBirth(String dateOfBirth)
    {
        fieldDateOfBirth.click();
        fieldDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));//highlight
        fieldDateOfBirth.sendKeys(dateOfBirth);
    }

    private void typeGender(Gender gender)
    {
        WebElement btnGender = driver.findElement(By.xpath(Gender.FEMALE.getLocator()));
        btnGender.click();
    }


}
