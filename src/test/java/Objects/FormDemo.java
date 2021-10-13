package Objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormDemo {

    private WebDriver driver;
    private By fullNameField = By.xpath("//*[@id=\"userName\"]");
    private By emailField = By.xpath("//*[@id=\"userEmail\"]");
    private By addressField = By.xpath("//*[@id=\"currentAddress\"]");
    private By pAddressField = By.xpath("//*[@id=\"permanentAddress\"]");
    private By submitButton = By.xpath("//*[@id=\"submit\"]");
    private String URLEnvironment = "https://demoqa.com/text-box";
    private By response = By.xpath("//*[@id=\"output\"]/div");

    public FormDemo(WebDriver driver) {
        this.driver = driver;
    }

    public void goToURL() {
        this.driver.get(URLEnvironment);
    }

    public void setFullNameField(String name) {
        driver.findElement(fullNameField).sendKeys(name);
    }

    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setpAddressField(String permanentAddress) {
        driver.findElement(pAddressField).sendKeys(permanentAddress);
    }

    public boolean submitForm() {
        WebElement button = driver.findElement(submitButton);
        button.sendKeys("ENTER");
        button.click();
        boolean displayAnswer = driver.findElement(response).isDisplayed();

        return displayAnswer;
    }


}

