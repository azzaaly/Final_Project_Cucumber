package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver=driver;
    }
    //locators
    private By usernameBox=By.id("sign-username");
    private By passwordBox=By.id("sign-password");
    private By signupButton=By.cssSelector("button[onclick='register()']");
    //actions
    public void insertUsername(String fakeUsername){
        driver.findElement(usernameBox).sendKeys(fakeUsername);
    }
    public void insertPassword(String fakerPassword){
        driver.findElement(passwordBox).sendKeys(fakerPassword);

    }
    public void clickOnSignupButton(){
        driver.findElement(signupButton).click();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public String getMessageAlert(){
  String message= driver.switchTo().alert().getText();
      return message;
    }
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    public void waitForAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
    }
}
