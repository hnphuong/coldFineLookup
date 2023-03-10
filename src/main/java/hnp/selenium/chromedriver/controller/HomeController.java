package hnp.selenium.chromedriver.controller;

import hnp.selenium.chromedriver.service.ColdPenaltyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    private final ColdPenaltyService coldPenaltyService;

    @GetMapping("/api/test-data")
    public ResponseEntity<String> testData() {
        String os = System.getProperty("os.name");
        return ResponseEntity.ok(os);
    }
}
