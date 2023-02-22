package hnp.selenium.chromedriver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
@Slf4j
public class MyController {
    @GetMapping("/")
    public String index() {
        log.debug("login");
        return "login";
    }

    @GetMapping("/s")
    public String search() {
        log.debug("search: " + new Date());
        return "search";
    }
}
