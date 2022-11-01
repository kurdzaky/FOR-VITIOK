import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameField = By.xpath("//input[@id='u_0_b_IN']");
    private By lastNameField = By.xpath("//input[@id='u_0_d_Qd']");
    private By phoneNumberOrEmail = By.xpath("//input[@id='u_0_g_F3']");
    private By password = By.xpath("//input[@id='password_step_input']");
    private By dayOfBirth = By.xpath("//select[@id='day']");
    private By monthOfBirth = By.xpath("//select[@id='month']");
    private By yearOfBirth = By.xpath("//select[@id='year']");
    private By buttonGenderSelectOptionFemale = By.xpath("//label[contains(text(),'Женщина')]");
    private By buttonGenderSelectOptionMale = By.xpath("//label[contains(text(),'Мужчина')]");
    private By buttonGenderSelectOptionOther = By.xpath("//label[contains(text(),'Другое')]");
    private By buttonRegister = By.xpath("//button[@id='u_0_s_GY']");
    private By linkAlreadyHaveAnAccount = By.xpath("//a[contains(text(),'У вас уже есть аккаунт?')]");
    private By errorMessage = By.xpath("//div[@id='js_r6']");
    private By errorSignFirstName = By.xpath("//body/div[@id='u_0_9_kh']/div[@id='globalContainer']/div[@id='content']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/i[1]");
    private By errorSignLastName = By.xpath("//body/div[@id='u_0_9_kh']/div[@id='globalContainer']/div[@id='content']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/i[1]");
    private By errorSignEmailOrPhoneField = By.xpath("//body/div[@id='u_0_9_kh']/div[@id='globalContainer']/div[@id='content']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/i[1]");
    private By errorSignPassword = By.xpath("//body/div[@id='u_0_9_kh']/div[@id='globalContainer']/div[@id='content']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/i[1]");
    private By errorSignGender = By.xpath("//body/div[@id='u_0_9_kh']/div[@id='globalContainer']/div[@id='content']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/i[1]");

    WebElement yearBirth = driver.findElement(By.xpath("//select[@id='year']"));

    {
        Select yearOfBirth = new Select(yearBirth);
        yearOfBirth.selectByVisibleText("1991");
    }

    WebElement monthBirth = driver.findElement(By.xpath("//select[@id='month']"));

    {
        Select monthOfBirth = new Select(monthBirth);
        monthOfBirth.selectByVisibleText("окт");
    }

    WebElement dayBirth = driver.findElement(By.xpath("//select[@id='day']"));

    {
        Select dayOfBirth = new Select(dayBirth);
        dayOfBirth.selectByVisibleText("24");
    }

    WebElement genderMaleButton = driver.findElement(By.xpath("//input[@id='u_0_6_QV']"));

    public void setGenderMaleButton(WebElement genderMaleButton) {
        this.genderMaleButton.click();
    }

    public SignUpPage typeUserName(String firstName) {
        driver.findElement(firstNameField);
        return this;
    }

    public SignUpPage typeLastName(String lastName) {
        driver.findElement(lastNameField);
        return this;
    }

    public SignUpPage typeUserEmailOrPhone(String userEmailOrPhone) {
        driver.findElement(phoneNumberOrEmail);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String firstName, String lastName, String email, String password) {
        this.typeUserName(firstName);
        this.typeLastName(lastName);
        this.typeUserEmailOrPhone(email);
        driver.findElement(buttonRegister);
        return new SignUpPage(driver);

    }

    public String getMainErrorText() {
        return driver.findElement(errorSignLastName).getText();
    }

    public String getUsernameErrorText() {
        return driver.findElement(errorSignFirstName).getText();
    }

    public String getPasswordErrorText() {
        return driver.findElement(errorSignPassword).getText();
    }

    public String getEmailErrorText() {
        return driver.findElement(errorSignEmailOrPhoneField).getText();

    }

}