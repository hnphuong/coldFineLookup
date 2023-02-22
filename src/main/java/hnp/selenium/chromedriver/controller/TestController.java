package hnp.selenium.chromedriver.controller;

import hnp.selenium.chromedriver.constant.Constants;
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

    @PostMapping(value = "/test")
    public String test(@Validated @RequestBody ColdPenaltyReq req) {
        String rs = testService.test(req);
        //String rs = "test";
        //testService.parseData("abc");
        return "result: " + rs;
    }

    @GetMapping(value = "/data")
    public ResponseEntity<BodyResponseDTO<ColdPenaltyRes>> testData(@Validated @RequestBody ColdPenaltyReq req) {
        String i18nMessage = messageUtils.populate(ApiResponseCode.SUCCESS.getMessage());
        ColdPenaltyRes dataRes = new ColdPenaltyRes();
        testService.parseData(Constants.DATA, req);
        dataRes.setData("data response");
        return RestResponseWrapper.getResponse(ApiResponseCode.SUCCESS, i18nMessage, dataRes);
    }
}
