package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    static String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void openBrowserRegTest() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        clickOnElement(By.xpath("//div[@id='loginPanel']/p[2]/a"));

        String expectedSignInMessage = "Signing up is easy!";

        String actualSignInMessage = getTextFromElement(By.xpath("//div[@id='rightPanel']/h1"));

        Assert.assertEquals("Easy signing Message: ", expectedSignInMessage, actualSignInMessage);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        clickOnElement(By.xpath("//div[@id='loginPanel']/p[2]/a"));
        sendTextToElement(By.name("customer.firstName"), "AmrendraBhai");
        sendTextToElement(By.id("customer.lastName"), "Bahubali");
        sendTextToElement(By.xpath("//input[@id='customer.address.street']"), "LionKing Street");
        sendTextToElement(By.xpath("//*[@id='customer.address.city']"), "Krukshetra");
        sendTextToElement(By.xpath("//input[@id='customer.address.state']"), "Cambridge");
        sendTextToElement(By.xpath("//input[@id='customer.address.zipCode']"), "389532");
        sendTextToElement(By.xpath("//input[@id='customer.phoneNumber']"), "123456789");
        sendTextToElement(By.xpath("//input[@id='customer.ssn']"), "987654321");
        sendTextToElement(By.xpath("//input[@id='customer.username']"), "Amrendra2");
        sendTextToElement(By.xpath("//input[@id='customer.password']"), "Bahubali");
        sendTextToElement(By.xpath("//input[@id='repeatedPassword']"), "Bahubali");
        clickOnElement(By.xpath("//td[@colspan='2']/input"));


        verifyText("Login Successfully Message:", "Your account was created successfully. You are now logged in.", By.xpath("//div[@id='bodyPanel']/div[2]/p"));


    }

    @After
    public void closeBrowserRegTest() {
        closeBrowser();
    }
}
