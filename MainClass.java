import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class MainClass {
    private static Logger logger = Logger.getLogger(MainClass.class);
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.register("asavsvsvsv", "ajsdjnajdnasd");

        loginPage.ClickSignIN();
        Thread.sleep (1000);

    }

}
