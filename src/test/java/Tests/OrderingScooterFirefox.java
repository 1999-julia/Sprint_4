package Tests;

import POM.HomePageScooter;
import POM.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class OrderingScooterFirefox {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.gecko.driver","C:\\tools\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    private WebDriver driver;

    private final String textExpected = "Заказ оформлен";

    @Test
    // тест нажатия нижней кнопки заказать в FireFox
    public void  pressBottomButtonOrderingFireFox() {

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickCookiesButton();
        objHomePage.scrollBottomButtonOrder();
        objHomePage.clickBottomButtonOrder();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.sendNameInput();
        objOrderPage.sendSurnameInput();
        objOrderPage.sendAddressInput();
        objOrderPage.sendPhoneInput();
        objOrderPage.sendMetroStationInput();
        objOrderPage.clickButtonFarther();
        objOrderPage.sendWhenInput();
        objOrderPage.sendRentalPeriodInput();
        objOrderPage.sendСolourInput();
        objOrderPage.sendCourierCommentInput();
        objOrderPage.clickButtonOrder();
        objOrderPage.clickButtonYes();
        objOrderPage.waitTextAppear(textExpected);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
