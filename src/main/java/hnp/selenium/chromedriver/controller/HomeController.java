package hnp.selenium.chromedriver.controller;

import hnp.selenium.chromedriver.constant.Constants;
import hnp.selenium.chromedriver.dto.User;
import hnp.selenium.chromedriver.dto.request.ColdPenaltyReq;
import hnp.selenium.chromedriver.service.TestService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    private final TestService testService;

    @RequestMapping("/index")
    public String index(Model model) {
        Map<Integer, List<String>> map = testService.resultData(Constants.DATA, "30H00368", "1");
        log.info("Spring Boot Thymeleaf Configuration Example");
        String[] array = new String[]{"red", "blue", "green"};
        List<String> colors = Arrays.asList(array);
        model.addAttribute("colors", colors);
        model.addAttribute("map", map);
        return "index";
    }

    @GetMapping(value = "/check")
    public String test(Model model) {
        log.info("Spring Boot Thymeleaf Example");
        ColdPenaltyReq penaltyReq = new ColdPenaltyReq();
        model.addAttribute("penaltyReq", penaltyReq);
        return "home";
    }

    @PostMapping("/home")
    public String submitForm(@ModelAttribute("request_data") ColdPenaltyReq request, Model model) {
        log.info("Spring Boot Thymeleaf Example");
        Map<Integer, List<String>> map = testService.resultData(Constants.DATA, "30H00368", "1");
        model.addAttribute("map", map);
        return "home_test";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User("1", "2", "3");
        model.addAttribute("user", user);

        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
        model.addAttribute("listProfession", listProfession);

        return "register_form";
    }
}
