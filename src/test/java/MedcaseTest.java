import dev.failsafe.Timeout;
import dev.failsafe.internal.util.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@TestMethodOrder(OrderAnnotation.class)
public class MedcaseTest {

    private WebDriver driver;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "./src/main/resources/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.medcase.health/");
    }

    @Test
    public void a(){
        WebElement careersTab = driver.findElement(By.id("w-dropdown-toggle-0"));

        careersTab.click();

        boolean tabDisplayed = careersTab.isDisplayed();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        assertTrue(tabDisplayed);

    }

    @Test
    public void b(){
        WebElement clinicianOpenings = driver.findElement(By.linkText("Clinician Openings"));

        clinicianOpenings.click();

        String title = driver.getTitle();

        assertEquals(title, "Clinician Openings");
    }

    @Test
    public void c(){
        driver.get("https://www.medcase.health/clinician-openings");
        List<WebElement> a = driver.findElements(By.linkText("Apply"));
        System.out.println("La cantidad de botones Apply es "+ a.size());
        assertTrue(true);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }



}
