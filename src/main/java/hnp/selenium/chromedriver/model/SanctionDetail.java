package hnp.selenium.chromedriver.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Getter
@Setter
public class SanctionDetail implements Serializable {
    private static final long serialVersionUID = 2405172041950251807L;

    @Field(value = "unique_key")
    private String uniqueKey;

    @Field(value = "license_plates")
    private String licensePlates;

    @Field(value = "license_plate_color")
    private String licensePlateColor;

    @Field(value = "type_vehicle")
    private String typeVehicle;

    @Field(value = "violation_time")
    private String violationTime;

    @Field(value = "violation_location")
    private String violationLocation;

    @Field(value = "violation")
    private String violation;

    @Field(value = "status")
    private String status;

    @Field(value = "violation_detection_unit")
    private String violationDetectionUnit;

    @Field(value = "place_to_solve")
    private PlaceToSolve placeToSolve;
}
