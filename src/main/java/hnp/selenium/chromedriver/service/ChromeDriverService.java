package hnp.selenium.chromedriver.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.emulation.Emulation;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
public class ChromeDriverService {
    private WebDriver driver;
    private ChromeDriver chromeDriver;

    public void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        options();
    }

    public void openChromeDriver() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        DevTools devTools = chromeDriver.getDevTools();
        devTools.createSession();
        // iPhone 11 Pro dimensions
        devTools.send(Emulation.setDeviceMetricsOverride(375,
                812,
                50,
                true,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));
        optionsChrome();
    }

    public void options() {
        driver.manage().window().setSize(new Dimension(375, 812));
    }

    public void optionsChrome() {
        chromeDriver.manage().window().setSize(new Dimension(375, 812));
    }

    public void close() {
        driver.close();
    }

    public void closeChrome() {
        chromeDriver.close();
    }
}
