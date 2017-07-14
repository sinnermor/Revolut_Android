package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by akordyukova on 10.07.2017.
 */
public class BankTransferPage extends BasePage {

    public BankTransferPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Button on main screen to call menu
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/button_transfer")
    private MobileElement menuButton;

    /**
     * Item for choosinf transfer option
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='To bank account']")
    private MobileElement toBankAccountButton;

    /**
     * Button Add new deneficiary
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/list_add_new_item_icon")
    private MobileElement addNewBeneficiaryButton;

    /**
     * Button skip
     */
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Skip']")
    private MobileElement skipButton;

    /**
     * Button next
     */
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
    private MobileElement nextButton;

    /**
     * Field for select country for beneficary
     */
    @AndroidFindBy(xpath = "//android.widget.EditText[@index=1]")
    private MobileElement countryField;

    /**
     * Field for search queries
     */
    @AndroidFindBy(xpath = "//android.widget.EditText[@index=0]")
    private MobileElement searchField;

    /**
     *
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Russia']")
    private MobileElement countrySelector;

    @AndroidFindBy(xpath = "//android.widget.TextView[@index=0]")
    private MobileElement countryFieldBenefits;

    /**
     * Press allow access to contacts and confirm it for Android
     */
    @AndroidFindBy(xpath = "//android.widget.EditText[@index=3]")
    private MobileElement currenccyField;

    /**
     * Press allow access to contacts and confirm it for Android
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Euro']")
    private MobileElement currencySelector;

    /**
     * Press allow access to contacts and confirm it for Android
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/first_name")
    private MobileElement firstNameField;

    /**
     * Press allow access to contacts and confirm it for Android
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/last_name")
    private MobileElement lastNameField;

    /**
     * Press allow access to contacts and confirm it for Android
     */
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Account number']")
    private MobileElement IBANField;

    /**
     * Press allow access to contacts and confirm it for Android
     */
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='BIC / SWIFT']")
    private MobileElement BICField;

    /**
     * Press allow access to contacts and confirm it for Android
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/mobile_phone")
    private MobileElement phoneField;

    /**
     * Press allow access to contacts and confirm it for Android
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/email")
    private MobileElement emailField;

    /**
     * Press allow access to contacts and confirm it for Android
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/wrapper_country")
    private MobileElement countryBenefField;

    /**
     * Press allow access to contacts and confirm it for Android
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/address_postal_code")
    private MobileElement postalCodeField;

    /**
     * Press allow access to contacts and confirm it for Android
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/address_line_1")
    private MobileElement adress1Field;

    /**
     * Press allow access to contacts and confirm it for Android
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/address_city")
    private MobileElement cityField;

    /**
     * Press allow access to contacts and confirm it for Android
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/address_region")
    private MobileElement stateField;


    public void selectTransferOption(String item) {
        menuButton.click();
        String locator = "//android.widget.TextView[@text='" + item + "']";
        driver.findElement(MobileBy.xpath(locator)).click();
        if (isElementPresentedByLocator(MobileBy.xpath("//android.widget.Button[@text='Learn more']"))) {
            skipButton.click();
        }
    }


    public void addNewBeneficiaryclick() {
        waitElementToBeClickable(addNewBeneficiaryButton);
        addNewBeneficiaryButton.click();
    }

    public void chooseTransferType(String textRadio) {
        String locator = "//android.widget.TextView[@text='" + textRadio + "']/preceding-sibling::*[1]";
        waitForVisibilityOf(MobileBy.xpath(locator));
        driver.findElement(By.xpath(locator)).click();
    }

    public void clickNextButton() {
        nextButton.click();
    }

    //    Create function with param country
    public void chooseCountryCurrence(String countryName, String selector) {
        if (selector.equals("country")) {
            countryField.click();
        } else if (selector.equals("currency")) {
            currenccyField.click();
        }
        searchSelectVoid(countryName);
    }

    public void searchSelectVoid(String countryName){
        searchField.click();
        searchField.sendKeys(countryName);
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.textToBePresentInElement(searchField, countryName));
        String locator = "//android.widget.TextView[@text='" + countryName + "']";
        driver.findElement(MobileBy.xpath(locator)).click();
    }

    public void fillAccountDetails(String firstname, String lastName, String iban, String swift, String phone, String email) {
        firstNameField.sendKeys(firstname);
        lastNameField.sendKeys(lastName);
        IBANField.sendKeys(iban);
        BICField.sendKeys(swift);
        phoneField.sendKeys(phone);
        emailField.sendKeys(email);

    }

    public void fillBeneficaryAdress(String country, String postCode, String adress, String city, String state) {
        countryFieldBenefits.click();
        searchSelectVoid(country);
        postalCodeField.sendKeys(postCode);
        adress1Field.sendKeys(adress);
        cityField.sendKeys(city);
        stateField.sendKeys(state);

    }


}
