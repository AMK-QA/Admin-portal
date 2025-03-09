package org.example.StepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

public class Hooks {
    public static WebDriver driver;
    public static Properties properties = new Properties();

    @Before
    public void setUp() throws IOException {
        FileInputStream file= new FileInputStream(new File("src/test/java/org/example/Properties/Config.properties"));
        properties.load(file);
        if(Objects.equals(properties.getProperty("browser"), "chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        } else if (Objects.equals(properties.getProperty("browser"), "edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--inprivate");
            driver = new EdgeDriver(options);
        } else if (Objects.equals(properties.getProperty("browser"), "firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--private");
            driver = new FirefoxDriver(options);
        }
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown()  {

        //driver.quit();
    }
}
