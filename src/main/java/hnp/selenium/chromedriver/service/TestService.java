package hnp.selenium.chromedriver.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@AllArgsConstructor
@Slf4j
public class TestService {
    private ChromeDriverService chromeDriverService;

    public String test() {
        chromeDriverService.setupChromeDriver();
        WebDriver driver = chromeDriverService.getDriver();
        String baseUrl = "https://www.csgt.vn/tra-cuu-phuong-tien-vi-pham.html";
        driver.get(baseUrl);
        // get the actual value of the title
        String rs = driver.getTitle();
        this.takeSnapShot(driver, "D:\\test_img\\test.png");
        chromeDriverService.close();
        return rs;
    }

    private void takeSnapShot(WebDriver webdriver, String fileWithPath) {
        try {
            //Convert web driver object to TakeScreenshot
            TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
            //Call getScreenshotAs method to create image file
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            //Move image file to new destination
            File destFile = new File(fileWithPath);
            //Copy file at destination
            FileUtils.copyFile(srcFile, destFile);
        } catch (Exception ex) {
            log.debug("error: " + ex.getMessage());
        }
    }
}
