package fabricio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;
class testSpotify {


    WebDriver driver;


    @FindBy(xpath = "//button[contains(text(),'Registra')]")

    WebElement btnRegistrase;


    @FindBy(xpath = "//span[contains(text(),'Prefiero no responder')]")

    WebElement genero;

    @FindBy(xpath = "//*[@id='__next']/main/div/div/form/div[8]/div/button/span[1]")

    WebElement ingresar;


//@FindBy(xpath = "//*[@id=\"__next\"]/main/div/div/form/div[7]/div/button/span[1]")

// WebElement registrarse;


//@FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/header/button[1]")

// WebElement mejorar;


    @BeforeAll

    static void preparacionClase() {

        WebDriverManager.chromedriver().setup();

    }


    @BeforeEach

    void preTests() {

        driver = new ChromeDriver();

        PageFactory.initElements(driver, this);

        driver.get("https://open.spotify.com/");


// Maximizar la página

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();


    }


    @Test

    void testEjemploSpotify() throws InterruptedException {


//Aqui crearemos el test

        btnRegistrase.click();

        Thread.sleep(10000);


// Crear usuario con correo electrónico

        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));

        email.sendKeys("dariomarconi@algo.com");


// Confirmación de correo electrónico

        WebElement confirmEmail = driver.findElement(By.xpath("//*[@id=\"confirm\"]"));

        confirmEmail.sendKeys("dariomarconi@algo.com");


// Cerrar cuadro de dialogo de las cookies

        WebElement cache = driver.findElement(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button"));

        cache.click();


// Contraseña

        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));

        password.sendKeys("hola-domingo-cachai");


// Cómo quieres que te llamemos?

        WebElement displayname = driver.findElement(By.xpath("//*[@id=\"displayname\"]"));

        displayname.sendKeys("dario654");


// Fecha de nacimiento

        WebElement birthMonth = driver.findElement(By.xpath("//*[@id=\"month\"]"));

        birthMonth.sendKeys("Febrero"); // Selecciona el mes de nacimiento

        WebElement birthDay = driver.findElement(By.xpath("//*[@id=\"day\"]"));

        birthDay.sendKeys("20"); // Selecciona el día de nacimiento

        WebElement birthYear = driver.findElement(By.xpath("//*[@id=\"year\"]"));

        birthYear.sendKeys("1996"); // Selecciona el año de nacimiento

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", genero);

        genero.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Noquiero);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement Noquiero = ( driver).findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/form/div[6]/div/label/span[1]"));

        Noquiero.click();

// WebElement mejora = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/header/button[1]"));

// Aquí hacemos click en el botón "Registrarse"

        WebElement registrarse = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/form/div[8]/div/button/span[1]"));

        ingresar.submit();

        registrarse.click();

// limpia el cache del navegador

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.localStorage.clear();");

// mejorar.click();

    }


    @AfterEach

    void posTests() {

//driver.close();

    }

}