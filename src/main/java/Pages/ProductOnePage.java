package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductOnePage {
    WebDriver driver;
    WebDriverWait wait;
    public ProductOnePage(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    private By addtoCartButton= By.cssSelector(".btn.btn-success.btn-lg");
    private By homeButtonLink=By.partialLinkText("Home");
    private By productTwo=By.partialLinkText("Iphone 6 32gb");
    public void clickOnAddToCartButton(){

        wait.until(ExpectedConditions.elementToBeClickable(addtoCartButton)).click();
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public String getTextAlert(){
        return driver.switchTo().alert().getText();
    }
    public void waitForAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
    }

    public void clickOnHomeButton(){

        wait.until(ExpectedConditions.elementToBeClickable(homeButtonLink)).click();

    }

    public ProductTwoPage clickToAddProductTwo(){
        driver.findElement(productTwo).click();
        return new ProductTwoPage(driver);
    }

}
