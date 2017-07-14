package scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BankTransferPage;
import pages.MainPage;


public class BankTransferTest extends AndroidSetup {


    @Before
    public void setUp() throws MalformedURLException {
        prepareAndroidForAppium();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void BankTransferTest() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        MainPage mainpage = new MainPage(driver);
        BankTransferPage bankpage = new BankTransferPage(driver);
        mainpage.getAuthorized("662266", "11111");
        bankpage.selectTransferOption("To bank account");
        mainpage.continueTap();
        bankpage.addNewBeneficiaryclick();
        bankpage.chooseTransferType("To myself");
        bankpage.clickNextButton();
        bankpage.chooseCountryCurrence("Russia", "country");
        bankpage.chooseCountryCurrence("EUR", "currency");
        bankpage.clickNextButton();
        bankpage.fillAccountDetails("Anastasiia", "Kordiukova", "662266", "AVJSRUMM", "+79102365599", "test@mail.ru");
        bankpage.clickNextButton();
        bankpage.fillBeneficaryAdress("Russia", "390006", "test", "Ryazan", "Ryazan");
//        bankpage.clickNextButton();

//   add assert and final step     assert ele
    }


}
