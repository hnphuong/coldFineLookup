package hnp.selenium.chromedriver.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ColdPenaltyRes {
    private String msg;
    private String data;
    private Map<Integer, List<String>> response;
}

