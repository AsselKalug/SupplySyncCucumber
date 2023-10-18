package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BranchPage {
    public BranchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
   @FindBy (xpath = "//li/div/span[contains(text(), 'Branches')]")
      public WebElement branch;

    @FindBy (xpath = "//div/button[contains(text(), 'Create Branch')]")
    public WebElement createBranch;

    @FindBy (id = "mui-2")
    public WebElement branchName;

    @FindBy (name = "email")
    public WebElement email;

    @FindBy (name = "address")
    public WebElement address;

    @FindBy (name = "phoneNumber")
    public WebElement phoneNumber;
    @FindBy (name = "city")
    public WebElement locationOfTheBranch;

    @FindBy (id = "mui-component-select-regionId")
    public WebElement selectRegion;
    @FindBy (xpath = "//ul/li[contains(text(), 'Bishkek city')]")
    public WebElement bishkekCity;

    @FindBy (id = "mui-component-select-cities")
    public WebElement selectCity;
    @FindBy (xpath = "//*[@id=\"menu-cities\"]/div[3]/ul/li[7]")
    public WebElement karasuuCheckBox;
    @FindBy (id = "mui-component-select-companyId")
    public WebElement companies;

    @FindBy (xpath = "//ul/li[contains(text(), 'Zulauf LLC'")
    public WebElement numberTwo;

   @FindBy (xpath = "/html/body/div[3]/div[3]/div[2]/div/button[2]")
    public WebElement create;





}
