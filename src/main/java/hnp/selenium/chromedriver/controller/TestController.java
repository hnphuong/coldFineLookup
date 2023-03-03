package hnp.selenium.chromedriver.controller;

import hnp.selenium.chromedriver.constant.Constants;
import hnp.selenium.chromedriver.constant.enums.ApiResponseCode;
import hnp.selenium.chromedriver.dto.BodyResponseDTO;
import hnp.selenium.chromedriver.dto.RestResponseWrapper;
import hnp.selenium.chromedriver.dto.request.ColdPenaltyReq;
import hnp.selenium.chromedriver.dto.response.ColdPenaltyRes;
import hnp.selenium.chromedriver.service.ColdPenaltyService;
import hnp.selenium.chromedriver.utils.MessageUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
@Slf4j
public class TestController {
    private ColdPenaltyService coldPenaltyService;
    private MessageUtils messageUtils;

    @PostMapping(value = "/test")
    public ResponseEntity<BodyResponseDTO<ColdPenaltyRes>> getColdPenalty(@Validated @RequestBody ColdPenaltyReq request) {
        //File file = new File("D:\\test_img\\3cfccbe9-e107-4d07-9b7f-012424e4a2fa_cut.png");
        //String rs = coldPenaltyService.readImage(file);
        //String rs = testService.test(req);
        //String rs = testService.testBrowsers();
        //testService.parseData("abc");
        String i18nMessage = messageUtils.populate(ApiResponseCode.SUCCESS.getMessage());
        ColdPenaltyRes dataRes = new ColdPenaltyRes();
        String dataResponse = coldPenaltyService.getColdPenalty(request);
        Map<Integer, List<String>> listMap = coldPenaltyService.resultData(dataResponse, request);
        dataRes.setResponse(listMap);
        dataRes.setStatus(1);
        return RestResponseWrapper.getResponse(ApiResponseCode.SUCCESS, i18nMessage, dataRes);
    }

    @GetMapping(value = "/data")
    public ResponseEntity<BodyResponseDTO<ColdPenaltyRes>> testData(@Validated @RequestBody ColdPenaltyReq req) {
        String i18nMessage = messageUtils.populate(ApiResponseCode.SUCCESS.getMessage());
        ColdPenaltyRes dataRes = new ColdPenaltyRes();
        coldPenaltyService.parseData(Constants.DATA, req);
        dataRes.setStatus(1);
        return RestResponseWrapper.getResponse(ApiResponseCode.SUCCESS, i18nMessage, dataRes);
    }
}
