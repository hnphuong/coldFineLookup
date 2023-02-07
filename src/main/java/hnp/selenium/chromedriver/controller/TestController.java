package hnp.selenium.chromedriver.controller;

import hnp.selenium.chromedriver.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class TestController {
    private TestService testService;

    @GetMapping(value = "/test")
    public String test() {
        String rs = testService.test();
        return "result: " + rs;
    }
}
