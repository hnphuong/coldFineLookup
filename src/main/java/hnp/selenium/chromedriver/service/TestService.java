package hnp.selenium.chromedriver.service;

import hnp.selenium.chromedriver.constant.Constants;
import hnp.selenium.chromedriver.constant.enums.TypeVehicle;
import hnp.selenium.chromedriver.dto.request.ColdPenaltyReq;
import hnp.selenium.chromedriver.model.PlaceToSolve;
import hnp.selenium.chromedriver.model.SanctionDetail;
import hnp.selenium.chromedriver.model.SanctionInformation;
import hnp.selenium.chromedriver.repository.SanctionInformationRepository;
import hnp.selenium.chromedriver.utils.DateUtil;
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
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class TestService {
    private ChromeDriverService chromeDriverService;
    private CropImageService cropImageService;
    private SanctionInformationRepository sanctionInformationRepository;

    public String test(ColdPenaltyReq req) {
        String data = this.getResultSearch(req);
        int i = 1;
        do {
            assert data != null;
            if (!data.equals(Constants.CAPTCHA_NOT_MATCH)) break;
            chromeDriverService.close();
            data = this.getResultSearch(req);
            i++;
        } while (i < 3);
        assert data != null;
        if (!data.isBlank() && !data.equals(Constants.SEARCH_NOT_FOUND) && !data.equals(Constants.CAPTCHA_NOT_MATCH)) {
            this.parseData(data, req);
        } else {
            String uniqueKey = req.getLicensePlates() + "#" + req.getTypeVehicle();
            Optional<SanctionInformation> isSanctionInformation = sanctionInformationRepository.findByUniqueKey(uniqueKey);
            if (isSanctionInformation.isPresent()) {
                data = isSanctionInformation.get().getResourceOriginal();
            } else {
                data = "";
            }
        }
        chromeDriverService.close();
        return data;
    }

    private String getResultSearch(ColdPenaltyReq req) {
        try {
            chromeDriverService.setupChromeDriver();
            WebDriver driver = chromeDriverService.getDriver();
            driver.get(Constants.URL_BASE_MOBILE);
            String captcha;
            String nameImage = UUID.randomUUID().toString();
            File fileCaptcha = this.takeSnapShot(driver, Constants.RESOURCE_ORIGIN.replace("###", nameImage), nameImage);
            if (fileCaptcha != null) {
                captcha = this.readImage(fileCaptcha);
            } else {
                return null;
            }
            WebElement licensePlates = driver.findElement(By.name("BienKiemSoat"));
            licensePlates.sendKeys(this.removeSpecialCharacters(req.getLicensePlates().trim()));
            Select drpTypeVehicle = new Select(driver.findElement(By.name("LoaiXe")));
            drpTypeVehicle.selectByValue(TypeVehicle.findTypeVehicleByCode(req.getTypeVehicle()));
            WebElement txtCaptcha = driver.findElement(By.name("txt_captcha"));
            assert captcha != null;
            txtCaptcha.sendKeys(this.removeSpecialCharacters(captcha.replace("Z", "7").replace("H", "5").toLowerCase()));
            WebElement search = driver.findElement(By.className("btnTraCuu"));
            search.click();
            Thread.sleep(2000);
            WebElement resultCaptcha = driver.findElement(By.className("xe_texterror"));
            if (resultCaptcha.getText().equals(Constants.CAPTCHA_NOT_MATCH)) return Constants.CAPTCHA_NOT_MATCH;
            WebElement resultSearch = driver.findElement(By.id("bodyPrint123"));
            return resultSearch.getAttribute("innerHTML");
        } catch (InterruptedException ex) {
            log.debug("error: " + ex.getMessage());
            return Constants.SEARCH_NOT_FOUND;
        }
    }

    public void parseData(String dataHtml, ColdPenaltyReq req) {
        String[] data = dataHtml.split("<hr style=\"margin-bottom: 25px;\">");
        Map<Integer, List<String>> parse = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            parse.put(i, this.analysisHtml(data[i]));
        }
        this.createSanctionInformation(parse, dataHtml, req.getLicensePlates(), req.getTypeVehicle());
    }

    public Map<Integer, List<String>> resultData(String dataHtml, String licensePlates, String typeVehicle) {
        String[] data = dataHtml.split("<hr style=\"margin-bottom: 25px;\">");
        Map<Integer, List<String>> parse = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            List<String> dataAnalysis = this.analysisHtml(data[i]);
            if (!dataAnalysis.isEmpty()) {
                parse.put(i, this.analysisHtml(data[i]));
            }
        }
        this.createSanctionInformation(parse, dataHtml, licensePlates, typeVehicle);
        return parse;
    }

    private List<String> analysisHtml(String html) {
        Document doc = Jsoup.parse(html);
        Elements details = doc.select("div.form-group");
        List<String> separates = new ArrayList<>();
        for (Element element : details) {
            separates.add(this.parseElement(element));
        }
        return separates;
    }

    private void createSanctionInformation(Map<Integer, List<String>> parse, String resourceOriginal, String licensePlates, String typeVehicle) {
        String uniqueKey = licensePlates + "#" + typeVehicle;
        Optional<SanctionInformation> isSanctionInformation = sanctionInformationRepository.findByUniqueKey(uniqueKey);
        if (isSanctionInformation.isPresent()) {
            List<SanctionDetail> sanctionDetails = new ArrayList<>();
            for (Map.Entry<Integer, List<String>> data : parse.entrySet()) {
                SanctionDetail sanctionDetail = this.sanctionDetail(data.getValue());
                if (sanctionDetail != null) {
                    sanctionDetails.add(sanctionDetail);
                }
            }
            isSanctionInformation.get().setSanctionDetails(sanctionDetails);
            sanctionInformationRepository.save(isSanctionInformation.get());
        } else {
            SanctionInformation sanctionInformation = new SanctionInformation();
            sanctionInformation.setUniqueKey(uniqueKey);
            sanctionInformation.setLicensePlates(licensePlates);
            sanctionInformation.setTypeVehicle(typeVehicle);
            sanctionInformation.setResourceOriginal(resourceOriginal);
            List<SanctionDetail> sanctionDetails = new ArrayList<>();
            for (Map.Entry<Integer, List<String>> sanctionDetail : parse.entrySet()) {
                sanctionDetails.add(this.sanctionDetail(sanctionDetail.getValue()));
            }
            sanctionInformation.setSanctionDetails(sanctionDetails);
            sanctionInformationRepository.save(sanctionInformation);
        }
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
            return key + "#" + value;
        } else {
            return element.html();
        }
    }

    private SanctionDetail sanctionDetail(List<String> details) {
        if (!details.isEmpty() && details.size() > 8) {
            SanctionDetail sanctionDetail = new SanctionDetail();
            PlaceToSolve placeToSolve = new PlaceToSolve();
            sanctionDetail.setLicensePlates(this.analysisData(details, Constants.LICENSE_PLATES));
            sanctionDetail.setLicensePlateColor(this.analysisData(details, Constants.LICENSE_PLATES_COLOR));
            sanctionDetail.setTypeVehicle(this.analysisData(details, Constants.TYPE_VEHICLE));
            String time = this.analysisData(details, Constants.VIOLATION_TIME);
            sanctionDetail.setViolationTime(time);
            sanctionDetail.setUniqueKey(DateUtil.stringToLong(time).toString());
            sanctionDetail.setViolationLocation(this.analysisData(details, Constants.VIOLATION_LOCATION));
            sanctionDetail.setViolation(this.analysisData(details, Constants.VIOLATION));
            sanctionDetail.setStatus(this.analysisData(details, Constants.STATUS));
            sanctionDetail.setViolationDetectionUnit(this.analysisData(details, Constants.VIOLATION_DETECTION_UNIT));
            placeToSolve.setName(details.get(details.size() - 3));
            placeToSolve.setAddress(details.get(details.size() - 2));
            placeToSolve.setPhone(details.get(details.size() - 1));
            sanctionDetail.setPlaceToSolve(placeToSolve);
            return sanctionDetail;
        }
        return null;
    }

    private String analysisData(List<String> details, String content) {
        for (String detail : details) {
            if (detail.contains(content)) return detail.split("#")[1];
        }
        return "";
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
            int x = 40;//this.calculateImage(bufferedImage.getWidth(), 7);
            int y = 550;//this.calculateImage(bufferedImage.getHeight(), 58);
            int w = 500;//this.calculateImage(bufferedImage.getWidth(), 55);
            int h = 110;//this.calculateImage(bufferedImage.getHeight(), 14);
            bufferedImage.getHeight();
            BufferedImage subImg = cropImageService.cropImage(bufferedImage, x, y, w, h);
            File pathFile = new File(Constants.RESOURCE_ORIGIN_CUT.replace("###", nameImage));
            ImageIO.write(subImg, "png", pathFile);
            return pathFile;
        } catch (Exception ex) {
            log.debug("error: " + ex.getMessage());
            return null;
        }
    }

    private Integer calculateImage(Integer length, Integer percent) {
        return (length * percent) / 100;
    }

    private String removeSpecialCharacters(String value) {
        if (value == null) return "";
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if ((ch < 'A' || ch > 'Z') && (ch < 'a' || ch > 'z') && (ch < '0' || ch > '9')) {
                value = value.substring(0, i) + value.substring(i + 1);
                i--;
            }
        }
        return value;
    }
}
