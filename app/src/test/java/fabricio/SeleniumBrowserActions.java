package fabricio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBrowserActions {
    @Test
    void browserActions(){
        //preparar el webdriver
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(); //instanciar un objeto webdriver (browser)

        //cargar una pagina

        driver.get("https://google.com");

        //maximizar browser
        driver.manage().window().maximize();

        //redireccionar a otra pagina
        driver.navigate().to("https://www.selenium.dev");

        //refresh
        driver.navigate().refresh();

        //volver a google
        driver.navigate().back();




    }
}
