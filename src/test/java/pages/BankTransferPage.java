package pages;

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

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.ImageView")
    private MobileElement menuButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='To bank account']")
    private MobileElement toBankAccountButton;


    public BankTransferPage continueTap(){
        continueButton.click();
        return this;
    }

    public BankTransferPage openBankTransfer(){
        menuButton.click();
        toBankAccountButton.click();
        return this;
    }
}
