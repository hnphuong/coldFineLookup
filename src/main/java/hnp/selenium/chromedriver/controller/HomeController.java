package hnp.selenium.chromedriver.controller;

import hnp.selenium.chromedriver.constant.Constants;
import hnp.selenium.chromedriver.service.TestService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    private final TestService testService;
    //@Value("${messages.home:default-value}")
    //private String message = Constants.DATA;

    @RequestMapping("/")
    public String welcome(Model model) {
        Map<Integer, List<String>> map = testService.resultData(Constants.DATA, "30H00368", "1");
        log.info("Spring Boot Thymeleaf Configuration Example");
        String[] array = new String[] {"red", "blue", "green"};
        List<String> colors = Arrays.asList(array);
        model.addAttribute("colors", colors);
        model.addAttribute("message", map);
        return "index";
    }
}
