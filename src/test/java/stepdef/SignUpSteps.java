package stepdef;

import Pages.HomePage;
import Pages.SignupPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpSteps {
    WebDriver driver=Hooks.getDriver();
    HomePage homePage=new HomePage(driver);
    SignupPage signupPage;
    Faker faker=new Faker();
    @Given("user opens homepage & click on Sign Up Button")
    public void user_opens_homepage_click_on_sign_up_button() {
      signupPage=homePage.clickOnSignUpButtonLink();

    }

    @When("user enters valid username & password & press on sign up button")
    public void userEntersValidUsernamePasswordPressOnSignUpButton() {
        String fakeUsername=faker.name().username();
        String fakerPassword=faker.internet().password();
        signupPage.insertUsername(fakeUsername);
        signupPage.insertPassword(fakerPassword);
        signupPage.clickOnSignupButton();
        signupPage.waitForAlert();

    }

    @Then("success message appears & user is switched to homePage")
    public void successMessageAppearsUserIsSwitchedToHomePage() throws InterruptedException {
        String actualResult=signupPage.getMessageAlert();
        signupPage.acceptAlert();
        String expectedResult="Sign up successful.";
        Assert.assertEquals(actualResult,expectedResult);
        Thread.sleep(1000);
    }
}
