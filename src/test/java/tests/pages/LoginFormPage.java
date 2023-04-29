/*
package tests.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginFormPage extends LoadableComponent<LoginFormPage> {
                                    //using the allocater we can find element of the page
    private final WebDriver driver;
    By loginField = By.id("field_email"); //by is a class from open org selenium that helps us find the element on the page
    By passwordField = By.id("field_password");

    By logInBtn =By.xpath(".//*[@data-l='t,sign_in']");
    public LoginFormPage(WebDriver driver) {
        this.driver = driver;
        isLoaded();
        //we'll pass the driver and wait for 5 seconds to wait for the elements to be available
    }

    @Override
    protected void load() {
        driver.get("https://ok.ru");
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

    @Override
    protected void isLoaded() throws Error {

        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(loginField));
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(passwordField));
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(logInBtn));
    }
    public void setLogin(String login) {
        driver.findElement(loginField).sendKeys(login);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public MainPage clickLoginBtn(){
        driver.findElement(logInBtn).click(); //page learnt how to click
        return new MainPage(driver);
    }
}*/

package tests.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginFormPage extends LoadableComponent<LoginFormPage> {

    private final WebDriver driver;
    private static final By FIELD_EMAIL = By.id("field_email");
    private static final By FIELD_PASSWORD = By.id("field_password");
    private static final By LOG_IN_BTN = By.xpath(".//*[@data-l='t,sign_in']");

    public LoginFormPage(WebDriver driver) {
        this.driver = driver;
        isLoaded();
    }

    @Override
    protected void load() {
        driver.get("https://ok.ru");
    }

    @Override
    protected void isLoaded() throws Error {
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(FIELD_EMAIL));
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(FIELD_PASSWORD));
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(LOG_IN_BTN));
    }

    public LoginFormPage setLogin(String login) {
        driver.findElement(FIELD_EMAIL).sendKeys(login);
        return this;
    }

    public LoginFormPage setPassword(String password) {
        driver.findElement(FIELD_PASSWORD).sendKeys(password);
        return this;
    }

    public MainPage clickLoginBtn() {
        driver.findElement(LOG_IN_BTN).click();
        return new MainPage(driver);
    }
}
