package com.automation.Pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@id='checking-menu']")
    WebElement checkingMenuBtn;

    @FindBy(xpath = "//a[@id='new-checking-menu-item']")
    WebElement newCheckingMenuBtn;

    //starts account Creation
    @FindBy(xpath = "//input[@id='Standard Checking']")
    WebElement stdCheckingBtn;

    @FindBy(xpath = "//input[@id='Individual']")
    WebElement individualBtn;

    @FindBy(xpath = "//input[@id='name']")
    WebElement accNameInput;

    @FindBy(xpath = "//input[@id='openingBalance']")
    WebElement depositInput;

    @FindBy(xpath = "//button[@id='newCheckingSubmit']")
    WebElement newCheckingSubmitBtn;

    @FindBy(xpath = "//*[@id='transfer-menu-item']")
    WebElement transferBtn;

    @FindBy(xpath = "//*[@id='fromAccount']")
    WebElement accType;

    @FindBy(xpath = "//*[@id='fromAccount']/option[5]")
    WebElement accSelect;

    @FindBy(xpath = "//*[@id='toAccount']")
    WebElement accToType;

    @FindBy(xpath = "//*[@id='toAccount']/option[4]")
    WebElement accToSelect;

    @FindBy(xpath = "//*[@id='amount']")
    WebElement accAmountIn;

    @FindBy(xpath = "//*[@id='right-panel']/div[2]/div/div/div/div/form/div[2]/button[1]")
    WebElement submit;

    @FindBy(xpath = "//*[@id='header']/div/div[2]/div[1]/a/img")
    WebElement profileIcon;

    @FindBy(xpath = "//*[@id='header']/div/div[2]/div[1]/div/a[3]")
    WebElement logoutOfSite;

    @FindBy(xpath = "//*[@id='savings-menu']")
    WebElement savings;

    @FindBy(xpath = "//*[@id='new-savings-menu-item']")
    WebElement accCreate;

    @FindBy(xpath = "//*[@id='Savings']")
    WebElement saveBtn;

    @FindBy(xpath = "//*[@id='right-panel']/div[2]/div/div/div/div/form/div[1]/div[3]/div[2]/label[1]")
    WebElement typeInd;

    @FindBy(xpath = "//*[@id='name']")
    WebElement savAccName;

    @FindBy(xpath = "//*[@id='openingBalance']")
    WebElement savAccAmount;

    @FindBy(xpath = "//*[@id='newSavingsSubmit']")
    WebElement submitClick;

    //Savings account

    public void checkingAccount() {
        checkingMenuBtn.click();
        newCheckingMenuBtn.click();
    }

    public void checkingAccCreation(String accName, String deposit) {
        stdCheckingBtn.click();
        individualBtn.click();
        accNameInput.sendKeys(accName);
        depositInput.sendKeys(deposit);
        newCheckingSubmitBtn.click();

    }

    public boolean verifyCheckingAccDetails(String name, String accType, String owner, String deposit) {
        WebElement accountNameElem = driver.findElement(By.xpath("//*[@id='firstRow']/div/div/form/div/div[1]"));
        String accNameStr = accountNameElem.getText();

        WebElement accountTypeElem = driver.findElement(By.xpath("//small[contains(text(), 'Account: Standard Checking')]"));
        String accTypeStr = accountTypeElem.getText();

        WebElement accountOwnerElem = driver.findElement(By.xpath("//small[contains(text(), 'Ownership: Individual')]"));
        String accOwnerStr = accountOwnerElem.getText();

        WebElement depositAmountElem = driver.findElement(By.xpath("//div[contains(text(), 'Balance: $10000.00')]"));
        String depositStr = depositAmountElem.getText();


        return accNameStr.contains(ConfigReader.getConfigValue("name")) &&
                accTypeStr.contains(ConfigReader.getConfigValue("accType")) && accOwnerStr.contains(ConfigReader.getConfigValue("owner"))
                && depositStr.contains(ConfigReader.getConfigValue("deposit"));
    }

    public void transfer() {
        transferBtn.click();
        accType.click();
        accSelect.click();
        accToType.click();
        accToSelect.click();
        accAmountIn.sendKeys("20");
        submit.click();
    }

    public void logout() {
        profileIcon.click();
        logoutOfSite.click();
    }

    public void savings() {
        savings.click();
        accCreate.click();
        saveBtn.click();
        typeInd.click();
        savAccName.sendKeys("Joe sav");
        savAccAmount.sendKeys("30000");
        submitClick.click();
    }
}
