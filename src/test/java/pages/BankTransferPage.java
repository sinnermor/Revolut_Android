package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by akordyukova on 10.07.2017.
 */
public class BankTransferPage extends  BasePage{

    protected WebDriver driver;

    public BankTransferPage(WebDriver driver){
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.Button")
    private MobileElement continueButton;

    @AndroidFindBy(id = "com.revolut.revolut.test:id/button_transfer")
    private MobileElement menuButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='To bank account']")
    private MobileElement toBankAccountButton;

    @AndroidFindBy(id = "com.revolut.revolut.test:id/list_add_new_item_icon")
    private MobileElement addNewBeneficiaryButton;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.ImageButton")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='To myself']/preceding-sibling::*[1]")
    private MobileElement myTransferButton;



    @AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
    private MobileElement nextButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index=1]")
    private MobileElement countryField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index=0]")
    private MobileElement searchField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Russia']")
    private MobileElement countrySelector;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index=3]")
    private MobileElement currenccyField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Euro']")
    private MobileElement currencySelector;





    public BankTransferPage continueTap(){
        continueButton.click();
        return this;
    }

    public BankTransferPage openBankTransfer(){
        menuButton.click();
        toBankAccountButton.click();
        if (isElementPresentedByLocator(MobileBy.xpath("//android.widget.Button[@text='Learn more']")))
                {
                    backButton.click();
                }
        return this;
    }

    public BankTransferPage addNewBeneficiaryclick(){
        waitElementToBeClickable(addNewBeneficiaryButton);
        addNewBeneficiaryButton.click();
        return this;
    }

    public BankTransferPage chooseTransferTypeMySelf(String textRadio){
        String locator = "//android.widget.TextView[@text='" + textRadio + "']/preceding-sibling::*[1]";
        waitForVisibilityOf(MobileBy.xpath(locator));
        myTransferButton.click();
//        driver.findElement(MobileBy.xpath(locator)).click();
//        element.click();
        return this;
    }

    public BankTransferPage clickNextButton(){
        nextButton.click();
        return this;
    }

    //    Create function with param country
    public BankTransferPage chooseCountry(String countryName){
        countryField.click();
        searchField.click();
        searchField.sendKeys(countryName);
//        (new WebDriverWait(driver, 5)).until(ExpectedConditions.textToBePresentInElement(searchField, countryName));
        countrySelector.click();
        return this;
    }

    public BankTransferPage chooseCurrency(String currency){
        currenccyField.click();
        searchField.click();
        searchField.sendKeys(currency);
        currencySelector.click();
        return this;
    }

}
