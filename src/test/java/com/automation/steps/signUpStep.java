package com.automation.steps;

import com.automation.Pages.SignUp;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class signUpStep {

    SignUp signUp = new SignUp();

    @Given("user login to the website")
    public void user_login_to_the_website() {
        signUp.signUpPage();
    }

    @When("user is on the login page click on signup")
    public void user_is_on_the_login_page_click_on_signup() {
        signUp.signUpFormFirst("Joe", "Who", "11/11/1111", "523546322", "rde@we.co", "Joewho@123",
                "Joewho@123"
        );
    }

    @When("user enters the valid signup details")
    public void user_enters_the_valid_signup_details() {
        signUp.signUpFormSecond("hdhse", "xvdssd", "jsrtjms", "63434", "TA", "1927117081", "1927117081",
                "1927117081");
    }

    @When("user enters the username {string} and password {string}")
    public void userEntersTheUsernameAndPassword(String username, String password) {
        signUp.doLogin(ConfigReader.getConfigValue(username), ConfigReader.getConfigValue(password));
    }

    @Then("user verifies the login page with title welcome {string}")
    public void user_verifies_the_login_page_with_title(String fname) {
        String message = signUp.verifyHomePage(ConfigReader.getConfigValue(fname));
        Assert.assertEquals("Welcome " + ConfigReader.getConfigValue(fname), message);
    }


}
