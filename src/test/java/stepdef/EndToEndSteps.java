package stepdef;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class EndToEndSteps {
    WebDriver driver=Hooks.getDriver();
    HomePage homePage=new HomePage(driver);
    LoginPage loginPage;
    ProductOnePage productOnePage;
    ProductTwoPage productTwoPage;
    CartPage cartPage;

    @Given("user opens homepage & click on Log in Button")
    public void userOpensHomepageClickOnLogInButton() {
        loginPage=homePage.clickOnLoginPageLink();
    }

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsInWithUsernameAndPassword(String username ,String password) throws InterruptedException {
        loginPage.enterUserName("Test_2025");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        String actualResult="welcome "+loginPage.validateusername();
        String expectedResult="Welcome Test_2025";
        Assert.assertTrue(actualResult.contains(expectedResult));


    }

    @When("user adds  first product {string} to the cart")
    public void userAddsFirstProductToTheCart(String arg0) throws InterruptedException {
        productOnePage=homePage.clickOnProductOne();
        productOnePage.clickOnAddToCartButton();
        productOnePage.waitForAlert();
        String actualResult = productOnePage.getTextAlert();
        productOnePage.acceptAlert();
        String expectedResult = "Product added.";
        Assert.assertEquals(actualResult,expectedResult);
        productOnePage.clickOnHomeButton();

    }

    @And("user adds second product {string} to the cart")
    public void userAddsSecondProductToTheCart(String arg0) throws InterruptedException {
        productTwoPage=homePage.clickToAddProductTwo();
        productTwoPage.ClickOnAddButton();
        productTwoPage.waitForAlert();
        String actualResult= productTwoPage.getTextAlert();
        productTwoPage.acceptAlert();
        String expectedResult="Product added.";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @When("users navigates to the cart")
    public void usersNavigatesToTheCart() throws InterruptedException {

        cartPage= homePage.ClickOnCartPage();

    }


    @Then("the cart should contains the products")
    public void theCartShouldContainsTheProducts(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<String> actualResultNames=cartPage.getProductNames();
        List<String> actualResultPrices=cartPage.getPrices();
        List<String>expectedResultNames= Arrays.asList("Nexus 6","Iphone 6 32gb");
        List<String>expectedResultPrices=Arrays.asList("650","790");
        Assert.assertTrue(actualResultNames.containsAll(expectedResultNames),"Not all expected product names are in the cart");
        Assert.assertTrue(actualResultPrices.containsAll(expectedResultPrices),"Not all expected product prices are in the cart");
    }

    @And("the total price should be {int}")
    public void theTotalPriceShouldBe(int arg0) throws InterruptedException {
        int actualTotal=cartPage.getTotalPrices();
        int expectedTotal=790+650;
        Assert.assertEquals(actualTotal,expectedTotal,"Total Price does not match expected");
        cartPage.clickPlaceOrderButton();

    }

    @When("users enters on places the order with:")
    public void usersEntersOnPlacesTheOrderWith(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        cartPage.insert("Azza","egypt","cairo","123","10","2020");
        cartPage.ClickOnPurchaseBtn();
    }

    @Then("the confirmation message should be {string}")
    public void theConfirmationMessageShouldBe(String arg0) throws InterruptedException {
        String actualResult=cartPage.ValidateMessage();
        String expectedResult="Thank you for your purchase!";
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(1000);

    }


}
