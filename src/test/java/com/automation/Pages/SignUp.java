package com.automation.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp extends BasePage {

    @FindBy(xpath = "//a[text()=' Sign Up Here']")
    WebElement signUpBtn;

    @FindBy(xpath = "//select[@id='title']")
    WebElement titleDropDown;

    @FindBy(xpath = "//select[@id='title']/option[text()='Mr.']")
    WebElement mrBtn;

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='gender' and @value='M']")
    WebElement genderInput;

    @FindBy(xpath = "//input[@id='dob']")
    WebElement dateOfBirth;

    @FindBy(xpath = "//input[@id='ssn']")
    WebElement socialSecurity;

    @FindBy(xpath = "//input[@id='emailAddress']")
    WebElement emailAddress;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    WebElement confirmPassword;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/button")
    WebElement nextBtn;

    @FindBy(xpath = "//input[@id='address']")
    WebElement addressInput;

    @FindBy(xpath = "//input[@id='locality']")
    WebElement localityInput;

    @FindBy(xpath = "//input[@id='region']")
    WebElement regionInput;

    @FindBy(xpath = "//input[@id='postalCode']")
    WebElement postalCodeInput;

    @FindBy(xpath = "//input[@id='country']")
    WebElement countryInput;

    @FindBy(xpath = "//input[@id='homePhone']")
    WebElement homePhoneInput;

    @FindBy(xpath = "//input[@id='mobilePhone']")
    WebElement mobilePhoneInput;

    @FindBy(xpath = "//input[@id='workPhone']")
    WebElement workPhoneInput;

    @FindBy(xpath = "//input[@id='agree-terms']")
    WebElement termsAndCondition;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/button")
    WebElement registerBtn;

    //loginPage
    @FindBy(xpath = "//input[@id='username']")
    WebElement loginUserName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement loginPassWord;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement loginSubmitBtn;


    public void signUpPage() {
        driver.get("https://dbank-qa.wedevx.co/bank/login");
    }

    public void signUpFormFirst(String firstname, String lastname, String dob, String security,
                                String email, String pWord, String confirmP) {
        signUpBtn.click();
        titleDropDown.click();
        mrBtn.click();
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        genderInput.click();
        dateOfBirth.sendKeys(dob);
        socialSecurity.sendKeys(security);
        emailAddress.sendKeys(email);
        password.sendKeys(pWord);
        confirmPassword.sendKeys(confirmP);
        nextBtn.click();
    }

    public void signUpFormSecond(String address, String locality, String region, String postal, String country,
                                 String home, String mobile, String work) {
        addressInput.sendKeys(address);
        localityInput.sendKeys(locality);
        regionInput.sendKeys(region);
        postalCodeInput.sendKeys(postal);
        countryInput.sendKeys(country);
        homePhoneInput.sendKeys(home);
        mobilePhoneInput.sendKeys(mobile);
        workPhoneInput.sendKeys(work);
        termsAndCondition.click();
        registerBtn.click();

    }

    public void doLogin(String firstValue, String secondValue) {
        loginUserName.clear();
        loginUserName.sendKeys(firstValue);
        loginPassWord.sendKeys(secondValue);
        loginSubmitBtn.click();

    }

    public String verifyHomePage(String fName) {
        WebElement msg = driver.findElement(By.xpath("//li[contains(text(), 'Welcome')]"));
        String msgText = msg.getText();
        return msgText;
    }

}
