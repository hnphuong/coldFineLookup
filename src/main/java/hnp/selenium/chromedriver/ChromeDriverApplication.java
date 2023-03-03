package hnp.selenium.chromedriver;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChromeDriverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChromeDriverApplication.class, args);
    }

    @Bean
    Tesseract getTesseract() {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("./tessdata");
        return tesseract;
    }
}
