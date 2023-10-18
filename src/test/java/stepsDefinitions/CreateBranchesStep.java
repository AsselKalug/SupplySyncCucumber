package stepsDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BranchPage;
import pages.LoginPage;
import utilities.Driver;

import java.time.Duration;
import java.util.Random;

public class CreateBranchesStep {
    WebDriver driver = Driver.getDriver();
    BranchPage branchPage = new BranchPage();
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @Given("the admin navigates to Supply Sync login page")
    public void the_admin_navigates_to_supply_sync_login_page() {
        driver.get("https://supplysync.us/login");
    }

    @When("the admin enters email, password and clicks login button")
    public void the_admin_enters_email_and_password() {
        loginPage.login();
    }
    @When("admin navigates to Branches")
    public void admin_navigates_to_branches() {
        branchPage.branch.click();

    }
    @When("admin clicks the create branch button")
    public void admin_clicks_the_create_branch_button() {
       branchPage.createBranch.click();
    }
    @Then("admin enters required information and press create button")
    public void admin_enters_required_information_and_press_create_button() throws InterruptedException {

        Random random = new Random();
        String nameOfBranch = random.toString();
        branchPage.branchName.click();
        branchPage.branchName.sendKeys(nameOfBranch);
        Thread.sleep(3000);
        branchPage.email.click();
        branchPage.email.sendKeys("harrypotter@gmail.com");
        Thread.sleep(2000);
        branchPage.address.sendKeys("123 Main Street");
        branchPage.phoneNumber.sendKeys("123456789");
        branchPage.locationOfTheBranch.click();
        branchPage.locationOfTheBranch.sendKeys("Brooklyn");
        branchPage.selectRegion.click();
        branchPage.bishkekCity.click();
        branchPage.selectCity.click();
        Thread.sleep(2000);
        branchPage.karasuuCheckBox.click();
        Actions actions = new Actions(driver);
        actions.moveByOffset(100, 100).click().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        branchPage.companies.click();
        Thread.sleep(2000);
        branchPage.numberTwo.click();
        Thread.sleep(3000);
        branchPage.create.click();
    }
}
