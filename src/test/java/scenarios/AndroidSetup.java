package scenarios;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;


/**
 * Created by akordyukova on 07.07.2017.
 */
public class AndroidSetup {

    protected AndroidDriver driver;
//    final String udid = "qweasd";


    protected void prepareAndroidForAppium() throws MalformedURLException {
        File appDir = new File("C:/Users/akordyukova/IdeaProjects/Revolut_Android/apps/");
        File app = new File(appDir, "Revolut_qa_4.3.0.237.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "Android");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
