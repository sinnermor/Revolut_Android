package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;

/**
 * Created by akordyukova on 10.07.2017.
 */
public class MainPage extends BasePage{
    protected WebDriver driver;

    final String login = "662266";
    final  String password = "1111";


    public MainPage(WebDriver driver){
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.Button")
    private MobileElement continueButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your phone number']")
    private MobileElement phoneLoginField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
    private MobileElement nextButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1']")
    private MobileElement pass_1;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Allow contact access']")
    private MobileElement allowAccesButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Разрешить']")
    private MobileElement confirmButton;


    public MainPage continueTap(){
        continueButton.click();
        return this;
    }

    public MainPage setLogin(String phonelogin){
        phoneLoginField.sendKeys(phonelogin);
        waitElementToBeClickable(nextButton);
        nextButton.click();
        return this;
    }

    public MainPage setPassword(){
        pass_1.click();
        pass_1.click();
        pass_1.click();
        pass_1.click();
        return this;
    }

    public MainPage allowAcces(){
        allowAccesButton.click();
        waitElementToBeClickable(confirmButton);
        confirmButton.click();
        return this;

    }


}
