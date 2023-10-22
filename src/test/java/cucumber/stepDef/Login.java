package cucumber.stepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    String baseurl = "https://saucedemo.com/";

    @Given(": User navigate to website")
    public void userNavigateToWebsite() {
        driver = new ChromeDriver();
        driver.get(baseurl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Swag Labs");
    }
    @When(": Enter valid <account>")
    public void enterValidAccount() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And(": Enter valid password")
    public void enterValidPassword() {
        WebElement findpass = driver.findElement(By.id("password"));
        findpass.sendKeys("secret_sauce");
    }

    @And(": Click on Log In button")
    public void clickOnLogInButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then(": User in on dashboard page <status>")
    public void userInOnDashboardPageStatus() {
        String ttxt = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals(ttxt,"Products");
        driver.close();
    }

    /*@Then(": User in on dashboard page")
    public void userInOnDashboardPage() {
        String ttxt = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals(ttxt,"Products");
    }*/

    @And(": Enter invalid password")
    public void enterInvalidPassword() {
        WebElement findpass = driver.findElement(By.id("password"));
        findpass.sendKeys("12345");
        driver.close();
    }

    @Then(": User get error message")
    public void userGetErrorMessage() {
        String ttxt = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(ttxt,"Kredensial yang anda berikan salah");
        driver.close();
    }
}
