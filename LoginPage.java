import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInButton = By.xpath("//a[text()='Вход']");
    private By signUpButton = By.xpath("//a[text()='Создать новый аккаунт']");
    private By userEmailOrPhoneNumberField = By.xpath("//input[@id='email']");
    private By password = By.xpath("//input[@id='pass']");
    private By forgotPassword = By.xpath("//a[contains(text(),'Забыли пароль?')]");
    private By error1 = By.xpath("//body/div[@id='u_0_0_M+']/div[@id='globalContainer']/div[@id='content']/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]");
    private By error2 = By.xpath("//a[contains(text(),'Найдите свой аккаунт и войдите в систему.')]");


    public void ClickSignIN() {
        driver.findElement(signInButton).click();
    }

    public LoginPage typeEmail (String email) {
            driver.findElement(userEmailOrPhoneNumberField).sendKeys(email);
            return this;
        }

            public LoginPage typePass (String pass) {
                driver.findElement(password).sendKeys(pass);
                return this;
    }

    public LoginPage register(String email, String pass) {
        this.typeEmail(email);
        this.typePass(pass);
        this.ClickSignIN();
        return new LoginPage(driver);
    }

    public LoginPage LogInWithInvalidCred(String email, String pass) {
        this.typeEmail(email);
        this.typePass(pass);
        driver.findElement(signInButton).click();
        return this;
    }

    public String getErrorText () {
        return driver.findElement(error1).getText();
    }
 }



