package TestCases;

import Objects.FormDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class testFORM {
    private WebDriver driver;
    private FormDemo form;

    @BeforeTest
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("resources/extension_1_4_5_0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void goToUrl() {
        form = new FormDemo(driver);
        this.form.goToURL();

    }

    @Test
    public void sendForm() {

        form.setFullNameField("mary");
        form.setEmailField("Test@test.com");
        form.setAddressField("RD");
        form.setpAddressField("US");
        Assert.assertTrue(form.submitForm(), "Something fail");


    }


    @AfterTest
    public void closedDriver() {

        this.driver.close();
        this.driver.quit();

    }
}
