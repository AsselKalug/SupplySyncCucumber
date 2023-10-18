package stepsDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CompaniesPage;
import pages.LogOutPage;
import pages.LoginPage;
import utilities.Driver;

import java.time.Duration;

public class LogOutStep {
    WebDriver driver = Driver.getDriver();
    CompaniesPage companiesPage = new CompaniesPage();
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    @When("the admin clicks on Administrator")
    public void the_admin_clicks_on_administrator() {
        LogOutPage logOutPage = new LogOutPage();
        logOutPage.administrator.click();

    }
    @Then("admin able to log out")
    public void admin_able_to_log_out() {
        LogOutPage logoutPage = new LogOutPage();
        logoutPage.exit.click();
        logoutPage.exitPopup.click();
        String expectedURL = "https://supplysync.us/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "User successfully logged out");
    }

    }


