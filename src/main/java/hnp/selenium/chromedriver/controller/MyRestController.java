package hnp.selenium.chromedriver.controller;

import hnp.selenium.chromedriver.constant.Constants;
import hnp.selenium.chromedriver.dto.AjaxResponseBody;
import hnp.selenium.chromedriver.dto.LoginForm;
import hnp.selenium.chromedriver.dto.User;
import hnp.selenium.chromedriver.dto.request.ColdPenaltyReq;
import hnp.selenium.chromedriver.dto.request.QuestionChatGPTRequest;
import hnp.selenium.chromedriver.dto.response.ChatGPTResponse;
import hnp.selenium.chromedriver.dto.response.ColdPenaltyRes;
import hnp.selenium.chromedriver.dto.response.chatGPT.Message;
import hnp.selenium.chromedriver.service.ChatGptService;
import hnp.selenium.chromedriver.service.ColdPenaltyService;
import hnp.selenium.chromedriver.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MyRestController {
    private final UserService userService;
    private final ColdPenaltyService coldPenaltyService;
    private final ChatGptService chatGptService;

    @PostMapping("/api/login")
    public ResponseEntity<AjaxResponseBody> getSearchResultViaAjax(@Valid @RequestBody LoginForm loginForm, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        List<User> users = userService.login(loginForm);
        if (users.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(users);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/api/result")
    public ResponseEntity<ColdPenaltyRes> getSearchResultViaAjax(@Valid @RequestBody ColdPenaltyReq request, Errors errors) {
        ColdPenaltyRes result = new ColdPenaltyRes();
        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        String dataResponse = coldPenaltyService.getColdPenalty(request);
        Map<Integer, List<String>> map = coldPenaltyService.resultData(dataResponse, request);//Constants.DATA
        log.debug(request.getLicensePlates() + " # " + request.getTypeVehicle());
        if (map.isEmpty()) {
            result.setMsg("Thất bại");
            result.setStatus(0);
        } else {
            result.setMsg("Thành công");
            result.setStatus(1);
        }
        result.setResponse(map);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/api/test-ajax")
    public ResponseEntity<ColdPenaltyRes> getTestAjax(@Valid @RequestBody ColdPenaltyReq request, Errors errors) {
        ColdPenaltyRes result = new ColdPenaltyRes();
        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        //String dataResponse = coldPenaltyService.getColdPenalty(request);
        Map<Integer, List<String>> map = coldPenaltyService.resultData(Constants.DATA, request);//Constants.DATA
        if (map.isEmpty()) {
            result.setMsg("Thất bại");
            result.setStatus(0);
        } else {
            result.setMsg("Thành công");
            result.setStatus(1);
        }
        result.setResponse(map);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/api/chat-gpt")
    public ResponseEntity<ChatGPTResponse> chatGpt(@Valid @RequestBody QuestionChatGPTRequest request) {
        ChatGPTResponse result = chatGptService.chatGPT(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/api/chat-completions")
    public ResponseEntity<Message> messageChatGpt(@Valid @RequestBody QuestionChatGPTRequest request) {
        Message result = chatGptService.messageChatGPT(request);
        return ResponseEntity.ok(result);
    }
}
