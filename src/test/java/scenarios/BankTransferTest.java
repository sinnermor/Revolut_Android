package scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BankTransferPage;
import pages.MainPage;


/**
 * Created by akordyukova on 10.07.2017.
 */
public class BankTransferTest extends AndroidSetup{

    @Before
    public void setUp() throws MalformedURLException {
        prepareAndroidForAppium();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void BankTransferTest() throws Exception {

        WebDriverWait wait  = new WebDriverWait(driver, 30);


        BankTransferPage bankpage = new BankTransferPage(driver);
        bankpage.continueTap();
        MainPage mainPage = new MainPage(driver);
        mainPage.setLogin("662266");
        mainPage.setPassword();
        mainPage.allowAcces();
        bankpage.openBankTransfer();
        mainPage.continueTap();
        bankpage.addNewBeneficiaryclick();
        bankpage.chooseTransferTypeMySelf("To myself");
        bankpage.clickNextButton();
        bankpage.chooseCountry("Russia");
        bankpage.chooseCurrency("EUR");
        bankpage.clickNextButton();
        bankpage.fillAccountDetails("Anastasiia", "Kordiukova", "662266", "AVJSRUMM", "+79102365599", "test@mail.ru");
        bankpage.clickNextButton();
        bankpage.fillBeneficaryAdress("Russia", "390006", "test", "Ryazan", "Ryazan");
        bankpage.clickNextButton();

//   add assert and final step     assert ele
    }



}
