package hnp.selenium.chromedriver.service;

import hnp.selenium.chromedriver.constant.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class TestService {
    private ChromeDriverService chromeDriverService;
    private CropImageService cropImageService;

    public String test() {
        chromeDriverService.setupChromeDriver();
        WebDriver driver = chromeDriverService.getDriver();
        String baseUrl = "https://www.csgt.vn/tra-cuu-phuong-tien-vi-pham.html";
        driver.get(baseUrl);
        // get the actual value of the title
        String captcha;
        String nameImage = UUID.randomUUID().toString();
        File fileCaptcha = this.takeSnapShot(driver, Constants.RESOURCE_ORIGIN.replace("###", nameImage), nameImage);
        //chromeDriverService.close();
        if (fileCaptcha != null) {
            captcha = this.readImage(fileCaptcha);
        } else {
            return null;
        }
        WebElement licensePlates = driver.findElement(By.name("BienKiemSoat"));
        licensePlates.sendKeys("30E48786");
        WebElement txtCaptcha = driver.findElement(By.name("txt_captcha"));
        assert captcha != null;
        txtCaptcha.sendKeys(this.removeSpecialCharacters(captcha.toLowerCase()));
        WebElement search = driver.findElement(By.className("btnTraCuu"));
        search.click();
        WebElement resultCaptcha = driver.findElement(By.className("xe_texterror"));
        if (resultCaptcha.getText().equals(Constants.CAPTCHA_NOT_MATCH)) return Constants.CAPTCHA_NOT_MATCH;
        WebElement resultSearch = driver.findElement(By.id("bodyPrint123"));
        String data = resultSearch.getAttribute("innerHTML");
        if (data.isBlank()) {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (!data.isBlank()) {
            log.debug(data);
        }
        return captcha;
    }

    public void parseData(String dataHtml) {
        String html = Constants.HTML5.replace("###", Constants.DATA);
        Document doc = Jsoup.parse(html);
        Elements hrs = doc.body().getElementsByTag("hr");
        System.out.println(hrs.size());
        log.debug("data: " + doc.title());
    }

    private String readImage(File fileImage) {
        Tesseract tesseract = new Tesseract();
        try {
            String resource = new ClassPathResource("tesseract").getFile().getCanonicalPath();
            tesseract.setDatapath(resource);
            return tesseract.doOCR(fileImage);
        } catch (TesseractException | IOException e) {
            log.debug("OCR Image: " + e.getMessage());
            return null;
        }
    }

    private File takeSnapShot(WebDriver webdriver, String fileWithPath, String nameImage) {
        try {
            //Convert web driver object to TakeScreenshot
            TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
            //Call getScreenshotAs method to create image file
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            //Move image file to new destination
            File destFile = new File(fileWithPath);
            //Copy file at destination
            FileUtils.copyFile(srcFile, destFile);
            BufferedImage bufferedImage = ImageIO.read(srcFile);
            BufferedImage subImg = cropImageService.cropImage(bufferedImage, 1290, 412, 180, 40);
            File pathFile = new File(Constants.RESOURCE_ORIGIN_CUT.replace("###", nameImage));
            ImageIO.write(subImg, "png", pathFile);
            return pathFile;
        } catch (Exception ex) {
            log.debug("error: " + ex.getMessage());
            return null;
        }
    }

    private String removeSpecialCharacters(String value) {
        if (value == null) return "";
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if ((ch < 'A' || ch > 'Z') && (ch < 'a' || ch > 'z')
                    && (ch < '0' || ch > '9')) {
                value = value.substring(0, i) + value.substring(i + 1);
                i--;
            }
        }
        return value;
    }
}
