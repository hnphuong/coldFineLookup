package hnp.selenium.chromedriver.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class ColdPenaltyReq {
    @NotNull(message = "Không được để trống licensePlates")
    private String licensePlates;
    @Pattern(regexp = "^(?=[1-3]$)(?!.*(.).*\\1).*$", message = "typeVehicle chỉ có giá trị 1, 2, 3")
    private String typeVehicle;
}
