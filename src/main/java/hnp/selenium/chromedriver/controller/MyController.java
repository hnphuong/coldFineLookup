package hnp.selenium.chromedriver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    private final Logger logger = LoggerFactory.getLogger(MyController.class);

    @GetMapping("/login")
    public String index() {
        logger.debug("login");
        return "login";
    }
}
