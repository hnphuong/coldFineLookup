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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class TestService {
    private ChromeDriverService chromeDriverService;
    private CropImageService cropImageService;

    public String test() {
        String data = this.getResultSearch();
        int i = 1;
        do {
            assert data != null;
            if (!data.equals(Constants.CAPTCHA_NOT_MATCH)) break;
            chromeDriverService.close();
            data = this.getResultSearch();
            System.out.println(i);
            i++;
        } while (i <= 3);
        if (!data.isBlank()) {
            log.debug(data);
            this.parseData(data);
        }
        return data;
    }

    private String getResultSearch() {
        try {
            chromeDriverService.setupChromeDriver();
            WebDriver driver = chromeDriverService.getDriver();
            String baseUrl = "https://www.csgt.vn/tra-cuu-phuong-tien-vi-pham.html";
            driver.get(baseUrl);
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
            Select drpTypeVehicle = new Select(driver.findElement(By.name("LoaiXe")));
            drpTypeVehicle.selectByValue("1");
            WebElement txtCaptcha = driver.findElement(By.name("txt_captcha"));
            assert captcha != null;
            txtCaptcha.sendKeys(this.removeSpecialCharacters(captcha.replace("Z", "7").replace("H", "5").toLowerCase()));
            WebElement search = driver.findElement(By.className("btnTraCuu"));
            search.click();
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            //wait.until(webDriver -> !webDriver.findElement(By.className("xe_texterror")).getText().isBlank());
            Thread.sleep(3000);
            WebElement resultCaptcha = driver.findElement(By.className("xe_texterror"));
            if (resultCaptcha.getText().equals(Constants.CAPTCHA_NOT_MATCH)) return Constants.CAPTCHA_NOT_MATCH;
            WebElement resultSearch = driver.findElement(By.id("bodyPrint123"));
            String data = resultSearch.getAttribute("innerHTML");
            if (data.isBlank() || data.contains("Không tìm thấy kết quả !")) {
                WebDriverWait waitResult = new WebDriverWait(driver, Duration.ofSeconds(7));
                waitResult.until(webDriver -> !webDriver.findElement(By.id("bodyPrint123")).getAttribute("innerHTML").contains("Không tìm thấy kết quả !"));
            }
            return data;
        } catch (Exception ex) {
            log.debug("error: " + ex.getMessage());
            return "";
        }
    }

    public void parseData(String dataHtml) {
        String html = Constants.HTML5.replace("###", dataHtml);
        Document doc = Jsoup.parse(html);
        //Elements hrs = doc.body().getElementsByTag("hr");
        //System.out.println("size: " + hrs.size());
        Elements details = doc.select("div.form-group");
        Map<Integer, List<String>> parse = new HashMap<>();
        int count = 0;
        int countElement = 0;
        List<String> separates = new ArrayList<>();
        for (Element element : details) {
            count++;
            separates.add(this.parseElement(element));
            if (count % 12 == 0) {
                parse.put(countElement, separates);
                countElement++;
                separates = new ArrayList<>();
                log.debug("element: " + element.html());
            }
        }
        log.debug("parse: " + parse.size());
    }

    private String parseElement(Element element) {
        if (!element.select("div.row").isEmpty()) {
            String key = element.select("div.row > label.col-md-3 > span").html();
            String value;
            if (element.select("div.row > div.col-md-9 > span").isEmpty()) {
                value = element.select("div.row > div.col-md-9").html();
            } else {
                value = element.select("div.row > div.col-md-9 > span").html();
            }
            return key + " # " + value;
        } else {
            return element.html();
        }
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
