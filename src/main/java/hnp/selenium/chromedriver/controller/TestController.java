package hnp.selenium.chromedriver.controller;

import hnp.selenium.chromedriver.constant.enums.ApiResponseCode;
import hnp.selenium.chromedriver.dto.BodyResponseDTO;
import hnp.selenium.chromedriver.dto.RestResponseWrapper;
import hnp.selenium.chromedriver.dto.request.ColdPenaltyReq;
import hnp.selenium.chromedriver.dto.response.ColdPenaltyRes;
import hnp.selenium.chromedriver.service.TestService;
import hnp.selenium.chromedriver.utils.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class TestController {
    private TestService testService;
    private MessageUtils messageUtils;

    @GetMapping(value = "/test")
    public String test() {
        //String rs = testService.test();
        String rs = "test";
        testService.parseData("abc");
        return "result: " + rs;
    }

    @GetMapping(value = "/data")
    public ResponseEntity<BodyResponseDTO<ColdPenaltyRes>> testData(@Validated @RequestBody ColdPenaltyReq req) {
        String i18nMessage = messageUtils.populate(ApiResponseCode.SUCCESS.getMessage());
        ColdPenaltyRes dataRes = new ColdPenaltyRes();
        dataRes.setData1("data response");
        return RestResponseWrapper.getResponse(ApiResponseCode.SUCCESS, i18nMessage, dataRes);
    }
}
