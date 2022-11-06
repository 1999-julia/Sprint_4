package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageScooter {
    private WebDriver driver;

    // локатор для элемента 'вопросы о важном'
    private By questionsImportant = By.xpath(".//div[text()='Вопросы о важном']");

    // локатор для элемента аккордеона
    private By elementAccordion;

    // локатор для текста элемента аккордеона
    private By elementTextAccordion;

    // локатор для верхней кнопки заказать
    private final By topButtonOrder = By.xpath(".//button[@class='Button_Button__ra12g'] ");

    // локатор для верхней кнопки заказать
    private final By  bottomButtonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'] ");
    // локатор для кнопки закрыть куку
    private final By buttonCookie = By.xpath(".//button[@class='App_CookieButton__3cvqF']");
    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // метод для прокрутки до элемента 'вопросы о важном'
    public void scrollQuestionsImportant() {
        WebElement element = driver.findElement(questionsImportant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // метод для нажатия на стрелочку элемента аккордеона
    public void clickAccordionArrow(int number) {
        if (number >= 1 ) {
            elementAccordion = By.id("accordion__heading-" + (number - 1));
        }
        driver.findElement(elementAccordion).click();
    }
    // метод для проверки появления соответствующего текста
    public void waitTextAppear(String textAccordion, int number) {
        if (number >= 1 ) {
            elementTextAccordion = By.id("accordion__panel-" + (number - 1));
        }
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.textToBePresentInElementLocated(elementTextAccordion, textAccordion));
    }

    // метод для нажатия на вкрхней кнопку заказать
    public void clickTopButtonOrder() {
        driver.findElement(topButtonOrder).click();
    }

    // метод для нажатия на нижнию кнопку заказать
    public void clickBottomButtonOrder() {
        driver.findElement( bottomButtonOrder).click();
    }
    // метод закрыть куки
    public void clickCookiesButton() {
        driver.findElement(buttonCookie).click();
    }

    // метод для прокрутки до нижней кнопки Заказать
    public void scrollBottomButtonOrder() {
        WebElement element = driver.findElement(bottomButtonOrder);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
