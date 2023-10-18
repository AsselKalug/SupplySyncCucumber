package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Driver {
    static WebDriver driver;
    public static WebDriver getDriver(){
/*
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Assel\\Desktop\\FirstJavaProject" +
                        "\\src\\SeleniumFirstProject\\src\\test\\drivers\\chromedriver");
*/

    if (driver!=null){
       return driver;
    }
   String browser =Config.getProperty("browser");
    switch (browser){
        case "chrome"-> driver = new ChromeDriver();

        case "firefox" -> driver = new FirefoxDriver();
        default -> driver = new ChromeDriver();
    }
    driver.manage().window().maximize();

    int pageLoadWaitTime=Integer.parseInt(Config.getProperty("pageLoadTime"));

    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWaitTime));

    int waitTime=Integer.parseInt(Config.getProperty("implicitWait"));

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));

    return driver;
}

    public static WebDriver getDriverWithoutNotifications(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Assel\\Desktop\\FirstJavaProject" +
                        "\\src\\SeleniumFirstProject\\src\\test\\drivers\\chromedriver");

        if (driver!=null){
            return driver;
        }
        String browser =Config.getProperty("browser");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
  //      WebDriver driver = new ChromeDriver(options);
        FirefoxOptions fireoptions = new FirefoxOptions();
        fireoptions.addArguments("disable-popup-blocking");

        switch (browser){
            case "chrome"-> driver = new ChromeDriver(options);

            case "firefox" -> driver = new FirefoxDriver(fireoptions);
            default -> driver = new ChromeDriver();
        }
        driver.manage().window().maximize();

        int pageLoadWaitTime=Integer.parseInt(Config.getProperty("pageLoadTime"));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWaitTime));

        int waitTime=Integer.parseInt(Config.getProperty("implicitWait"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));

        return driver;
    }


    public static void closeBrowser(){
        if (driver!= null){
            driver.quit();
            driver = null;
        }
    }


}
