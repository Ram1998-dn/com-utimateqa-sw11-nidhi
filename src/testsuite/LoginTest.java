package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;
public class LoginTest extends BaseTest {


    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Click on the 'Sign In' link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        String actualText = driver.findElement(By.xpath("//h2[contains(text()),'Welcome Back!']")).getText();
        String expectedText = "Welcome Back!";
        Assert.assertEquals("Text verification failed!",expectedText,actualText);
    }

  @Test
    public void verifyTheErrorMessage() {
        // Click on the 'Sign In' link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        // Enter the invalid username
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("invalid@example.com");

        // Enter the invalid password
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("invalidpassword");

        // Click on the 'Sign in' button
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(@class, 'button-primary')]"));
        signInButton.click();

         //Verify the error message 'Invalid email or password.'
        String actualmessage  =  driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]")).getText();
        String expectedMessage = "Invalid email or password.";
        Assert.assertEquals("Error message verification failed!", expectedMessage,actualmessage);

    }

}
