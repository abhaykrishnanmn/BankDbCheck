package com.automation.steps;

import com.automation.Pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class HomeSteps {

    HomePage homePage = new HomePage();


    @Then("click on checking and create a new account")
    public void click_on_checking_and_create_a_new_account() {
        homePage.checkingAccount();
    }

    @Then("provide name {string} and initial deposit {string}")
    public void provide_name_and_initial_deposit(String accName, String deposit) {
        homePage.checkingAccCreation(ConfigReader.getConfigValue(accName), ConfigReader.getConfigValue(deposit));
    }

    @Then("verify name {string}, account type {string}, ownership {string} and deposit {string} are displayed")
    public void verify_name_account_type_ownership_and_balance_are_displayed(String name, String Type, String owner, String amount) {
        homePage.verifyCheckingAccDetails(ConfigReader.getConfigValue(name), ConfigReader.getConfigValue(Type),
                ConfigReader.getConfigValue(owner), ConfigReader.getConfigValue(amount));
    }

    @And("transfer money to other account")
    public void transferMoneyToOtherAccount() {
        homePage.transfer();
    }

    @Then("Logout")
    public void logout() {
        homePage.logout();
    }

    @Then("click on savings account")
    public void clickOnSavingsAccount() {
        homePage.savings();
    }
}
