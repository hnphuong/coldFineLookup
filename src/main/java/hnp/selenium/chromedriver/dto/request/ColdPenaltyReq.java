package hnp.selenium.chromedriver.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColdPenaltyReq {
    private String licensePlates;
    private Integer typeVehicle;
}
