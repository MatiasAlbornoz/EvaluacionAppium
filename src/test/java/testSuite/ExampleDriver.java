package testSuite;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

import static conexion.DriverContext.setUp;

public class ExampleDriver {

    @BeforeMethod
    public void iniciarSession() {
//        AppiumDriver driver;
//        URL server = null;
//        try {
//            server = new URL("http://127.0.0.1:4723/wd/hub");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("deviceName", "emulator-5554");
//        cap.setCapability("platformName", "Android");
//        cap.setCapability("app", "C:\\Users\\exjvilr\\Downloads\\registroDeUsuarios.apk");
//        cap.setCapability("udid", "emulator-5554");
//
//        driver = new AndroidDriver(server, cap);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        setUp("emulador-5554", "Android", "C:\\Users\\exjvilr\\Downloads\\registroDeUsuarios.apk", "emulador-5554", true);
    }

    @Test()
    public  void test1() {
        System.out.println("Prueba");
    }
}
