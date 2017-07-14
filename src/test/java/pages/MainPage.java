package pages;

import io.appium.java_client.MobileBy;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by akordyukova on 10.07.2017.
 */
public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Button continue
     */
    @AndroidFindBy(xpath = "//android.widget.Button")
    private MobileElement continueButton;

    /**
     * Field for type phone as login
     */
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your phone number']")
    private MobileElement phoneLoginField;

    /**
     * Buttom with text NEXT
     */
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
    private MobileElement nextButton;

    /**
     * Button for allow access to contacts
     */
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Allow contact access']")
    private MobileElement allowAccessButton;

    /**
     * Button for confirm asccess from ANDROID
     */
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Allow']")
    private MobileElement confirmButton;


    /**
     * Set login with phone as param
     */
    public void setLogin(String phonelogin) {
        phoneLoginField.sendKeys(phonelogin);
        waitElementToBeClickable(nextButton);
        nextButton.click();
    }

    /**
     * Set password as param
     */
    public void setPassword(String numb) {
        for (int i = 0; i < 4; ++i) {
            String locator = "//android.widget.TextView[@text='" + numb.charAt(i) + "']";
            waitForVisibilityOf(MobileBy.xpath(locator));
            WebElement el = driver.findElement(By.xpath(locator));
            el.click();
        }
    }

    /**
     * Press tap at continue button
     */
    public void continueTap() {
        waitElementToBeClickable(continueButton);
        continueButton.click();
    }

    /**
     * Press allow access to contacts and confirm it for Android
     */
    public void allowAccess() {
        isElementPresentedByLocator(MobileBy.xpath("//android.widget.TextView[@text='To bank account']"));
        allowAccessButton.click();
        waitElementToBeClickable(confirmButton);
        confirmButton.click();
    }

    /**
     * Get authorized
     */
    public void getAuthorized(String login, String password) {
        continueTap();
        setLogin(login);
        setPassword(password);
        allowAccess();
    }

}
