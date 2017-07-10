package scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
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
    public void BankTransferTest() {
        MainPage mainPage;
        BankTransferPage bankpage;
        bankpage = new BankTransferPage(driver).continueTap();
        mainPage = new MainPage(driver).setLogin("662266");
        mainPage.setPassword();
        mainPage.allowAcces();
        bankpage.openBankTransfer();
        mainPage.continueTap();
    }





}
