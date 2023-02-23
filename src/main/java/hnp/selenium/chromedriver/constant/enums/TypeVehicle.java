package hnp.selenium.chromedriver.constant.enums;

import lombok.Getter;

@Getter
public enum TypeVehicle {
    CAR("1", 1, "Ô tô"),
    MOTORBIKE("2", 2, "Xe máy"),
    BICYCLE("3", 3, "Xe đạp");

    private final String code;
    private final Integer type;
    private final String description;

    TypeVehicle(String code, Integer type, String description) {
        this.code = code;
        this.type = type;
        this.description = description;
    }

    public static String findTypeVehicleByCode(String code) {
        for (TypeVehicle typeVehicle : TypeVehicle.values()) {
            if (typeVehicle.getCode().equals(code))
                return typeVehicle.getCode();
        }
        return "1";
    }
}
