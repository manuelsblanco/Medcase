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

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
        driver.navigate().to("https://www.medcase.health/clinician-openings");
        List<WebElement> buttons = driver.findElements(By.linkText("Apply"));
        long clicks = 0 ;
        for(int a = 0 ; a < buttons.size() ; a++){

            buttons.get(a).click();
            clicks++;
            driver.navigate().to("https://www.medcase.health/clinician-openings");
            buttons.clear();
            buttons = driver.findElements(By.linkText("Apply"));

        }
        assertEquals(clicks,buttons.size());
    }

    @After
    public void tearDown() {
        //driver.quit();
    }



}
