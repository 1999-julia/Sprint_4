package POM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class OrderPage {
    private WebDriver driver;

    // локатор для поля Имя
    private final By nameInputField = By.xpath(".//input[@placeholder='* Имя']");

    // локатор для поля Фамилия
    private final By surnameInputField = By.xpath(".//input[@placeholder='* Фамилия']");

    // локатор для поля Адрес
    private final By addressInputField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // локатор для поля Телефон
    private final By phoneInputField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // локатор для поля Станция метро
    private final By metroStationInputField = By.className("select-search__input");

    // локатор для выбора Станции метро
    private final By metroStationSelect = By.className("select-search__select");

    // локатор для кнопки Далее
    private final By buttonFurther = By.xpath(".//button[text()='Далее']");

    // локатор для поля Когда
    private final By whenInputField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // локатор для поля Срок аренды
    private final By pentalPeriodInputField = By.className("Dropdown-placeholder");

    // локатор для выбора срока аренды
    private final By pentalPeriodInput = By.xpath(".//div[text()='семеро суток']");

    // локатор для выбора цвета
    private final By colourField = By.id("black");

    // локатор для комментария курьеру
    private final By courierCommentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // локатор для кнопки заказать
    private final By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // локатор для кнопки Да
     private final By buttonYes = By.xpath(".//button[text()='Да']");

    // локатор для ообщениея об успешном создании заказа
    private final By textMessage = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод для заполнения поля * Имя
    public void sendNameInput() {
        driver.findElement(nameInputField).sendKeys("Юлия");
    }

    // метод для заполнения поля * Фамилия
    public void sendSurnameInput() {
        driver.findElement(surnameInputField).sendKeys("Евтеева");
    }

    // метод для заполнения поля * Адрес
    public void sendAddressInput() {
        driver.findElement(addressInputField).sendKeys("ул. Перово д. 6 кв. 1");
    }

    // метод для заполнения поля * Телефон
    public void sendPhoneInput() {
        driver.findElement(phoneInputField).sendKeys("89774569175");
    }

    // метод для заполнения станции метро
    public void sendMetroStationInput() {
        driver.findElement(metroStationInputField).click();
        driver.findElement(metroStationInputField).sendKeys("Соколиная Гора");
        driver.findElement(metroStationSelect).click();
    }

    //  клик кнопки далее
    public void clickButtonFarther() {
        driver.findElement(buttonFurther).click();
    }

    // метод для заполнения поля * Когда привезти самокат
    public void sendWhenInput() {
        driver.findElement(whenInputField).sendKeys("30.11.2022");
        driver.findElement(whenInputField).sendKeys(Keys.ENTER);
    }

    // метод для заполнения поля * Срок аренды самоката
    public void sendRentalPeriodInput() {
        driver.findElement(pentalPeriodInputField).click();
        driver.findElement(pentalPeriodInput).click();
    }

    // метод для выбора цвета
    public void sendСolourInput() {
        driver.findElement(colourField).click();
    }

    // метод коментария курьеру
    public void sendCourierCommentInput() {
        driver.findElement(courierCommentField).sendKeys("Не звонить в дверь!");
    }

    // метод нажатия кнопки Заказать
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    // метод нажатия кнопки Да
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    // метод для проверки появления сообщениея об успешном создании заказа
    public void waitTextAppear(String textExpected) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElementLocated(textMessage,  textExpected));
    }
}
