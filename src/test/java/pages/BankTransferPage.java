package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.font.TrueTypeFont;

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
     * Selector for choosing country
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Russia']")
    private MobileElement countrySelector;

    /**
     * Selector country in benefits tab
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@index=0]")
    private MobileElement countryFieldBenefits;

    /**
     * Field for choosing currency
     */
    @AndroidFindBy(xpath = "//android.widget.EditText[@index=3]")
    private MobileElement currenccyField;

//    /**
//     * Select currency EUR
//     */
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Euro']")
//    private MobileElement currencySelector;

    /**
     * Field for first name
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/first_name")
    private MobileElement firstNameField;

    /**
     * Field for last name
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/last_name")
    private MobileElement lastNameField;

    /**
     * Field for IBAN
     */
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Account number']")
    private MobileElement IBANField;

    /**
     * Field for BICF
     */
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='BIC / SWIFT']")
    private MobileElement BICField;

    /**
     * Field for phone
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/mobile_phone")
    private MobileElement phoneField;

    /**
     * Field for email
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/email")
    private MobileElement emailField;

    /**
     * Field for country
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/wrapper_country")
    private MobileElement countryBenefField;

    /**
     * Field for post code
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/address_postal_code")
    private MobileElement postalCodeField;

    /**
     * Field for adress
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/address_line_1")
    private MobileElement adress1Field;

    /**
     * Field for city
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/address_city")
    private MobileElement cityField;

    /**
     * Field for state
     */
    @AndroidFindBy(id = "com.revolut.revolut.test:id/address_region")
    private MobileElement stateField;

    /**
     * Finished test view
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@index=1]")
    private MobileElement finishedTextView;


    /**
     * Procedure for choosing transfer type.
     * Param - type text transfer option to create locator
     */
    public void selectTransferOption(String item) {
        menuButton.click();
        String locator = "//android.widget.TextView[@text='" + item + "']";
        driver.findElement(MobileBy.xpath(locator)).click();
        if (isElementPresentedByLocator(MobileBy.xpath("//android.widget.Button[@text='Learn more']"))) {
            skipButton.click();
        }
    }

    /**
     * Click  to Add beneficary button
     */
    public void addNewBeneficiaryclick() {
        waitElementToBeClickable(addNewBeneficiaryButton);
        addNewBeneficiaryButton.click();
    }

    /**
     * Choose transfer type in radio button
     * Param - text transfer type to create locator
     */
    public void chooseTransferType(String textRadio) {
        String locator = "//android.widget.TextView[@text='" + textRadio + "']/preceding-sibling::*[1]";
        waitForVisibilityOf(MobileBy.xpath(locator));
        driver.findElement(By.xpath(locator)).click();
    }

    /**
     * Click  to button with text next
     */
    public void clickNextButton() {
        nextButton.click();
    }

    /**
     * Select country or currency
     * Param 'countryname' - county or currency text ('Russia'),
     * Param selector can be "country" or "currency"
     */
    public void chooseCountryCurrence(String countryName, String selector) {
        if (selector.equals("country")) {
            countryField.click();
        } else if (selector.equals("currency")) {
            currenccyField.click();
        }
        searchSelectVoid(countryName);
    }

    /**
     * Procedure for searching and select queries(for example - country)
     */
    public void searchSelectVoid(String countryName) {
        searchField.click();
        searchField.sendKeys(countryName);
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.textToBePresentInElement(searchField, countryName));
        String locator = "//android.widget.TextView[@text='" + countryName + "']";
        driver.findElement(MobileBy.xpath(locator)).click();
    }

    /**
     * Fill account details with params
     */
    public void fillAccountDetails(String firstname, String lastName, String iban, String swift, String phone, String email) {
        firstNameField.sendKeys(firstname);
        lastNameField.sendKeys(lastName);
        IBANField.sendKeys(iban);
        BICField.sendKeys(swift);
        phoneField.sendKeys(phone);
        emailField.sendKeys(email);
    }

    /**
     * Fill beneficary adress with params
     */
    public void fillBeneficaryAdress(String country, String postCode, String adress, String city, String state) {
        countryFieldBenefits.click();
        searchSelectVoid(country);
        postalCodeField.sendKeys(postCode);
        adress1Field.sendKeys(adress);
        cityField.sendKeys(city);
        stateField.sendKeys(state);
    }


    public boolean checkSucessAdded() {
        String finishText = finishedTextView.getText();
        if (finishText == "Beneficiary Anastasiia Kordiukova was successfully created") {
            return true;
        } else {
            return false;
        }
    }


}
