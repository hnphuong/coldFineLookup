package hnp.selenium.chromedriver.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

@Service
@Getter
public class ChromeDriverService {
    WebDriver driver;

    public void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        options();
    }

    public void options() {
        driver.manage().window().maximize();
    }

    public void close() {
        driver.close();
    }
}
