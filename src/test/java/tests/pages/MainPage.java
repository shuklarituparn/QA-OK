package tests.pages;

import com.sun.tools.javac.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPage extends LoadableComponent<MainPage> {

    private WebDriver driver;
    private static final By USER_NAME = By.xpath(".//*[@data-l='t,userPage']"); //xpath method of username
    private static final By LENTA = By.xpath(".//*[contains(@id, 'UserMainFullMRB')]");  //xpath method of the Lenta
    private static final By USER_AVATAR = By.id("viewImageLinkId"); //Xpath expression of the User Avatar

    public MainPage(WebDriver driver) {
        this.driver = driver;
        isLoaded();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(USER_NAME));  //Using isloaded to check if the page objects are loaded
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(LENTA)); //checking if the Lenta is loaded
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(USER_AVATAR));  //checking if the USER_AVATAR is loaded

    }

    public String getName() {
        return driver.findElement(USER_NAME).getText();   //Finding the element from the page
    }
}
