package hnp.selenium.chromedriver.constant.enums;

import hnp.selenium.chromedriver.constant.Constants;
import org.springframework.http.HttpStatus;

public enum ApiResponseCode {
    SUCCESS(HttpStatus.OK, 1, "CTBINF200", "GLOBAL.SUCCESS"),
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 0, "CTBERR500", "GLOBAL.SERVER_ERROR"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, 0, Constants.CTBERR400, "GLOBAL.BAD_REQUEST"),
    BAD_REQUEST_CREATE(HttpStatus.BAD_REQUEST, 0, Constants.CTBERR400, "GLOBAL.BAD_REQUEST_CREATE"),
    UPDATED_SUCCESS(HttpStatus.OK, 0, "CTBINF200", "GLOBAL.UPDATED_SUCCESS"),
    OTHER_INFO_CONFIG_NOT_EXIST(HttpStatus.BAD_REQUEST, 0, "IPE012", "OTHER_INFO_CONFIG_NOT_EXIST"),
    INPUT_PARAMS_INVALID(HttpStatus.BAD_REQUEST, 0, Constants.CTBERR400, "INPUT_PARAMS_INVALID"),
    NOT_EXIST(HttpStatus.BAD_REQUEST, 0, Constants.CTBERR404, "GLOBAL.ID_IS_NOT_EXIST"),
    NOT_FOUND(HttpStatus.BAD_REQUEST, 0, Constants.CTBERR400, "GLOBAL.NOT_FOUND"),
    TIME_OUT(HttpStatus.REQUEST_TIMEOUT, 0, "CTBERR408", "GLOBAL.TIME_OUT"),
    ALREADY_EXIST(HttpStatus.BAD_REQUEST, 0, Constants.CTBERR400, "GLOBAL.ALREADY_EXIST"),
    EXPECTATION_FAILED(HttpStatus.EXPECTATION_FAILED, 0, "CTBERR417", "GLOBAL.EXPECTATION_FAILED"),
    UNPROCESSABLE_ENTITY(HttpStatus.UNPROCESSABLE_ENTITY, 0, "CTBERR422", "GLOBAL.UNPROCESSABLE_ENTITY"),
    REQUEST_TIMEOUT(HttpStatus.REQUEST_TIMEOUT, 0, "CTBERR408", "GLOBAL.REQUEST_TIMEOUT"),
    FIELD_REQUIRED(HttpStatus.BAD_REQUEST, 0, Constants.CTBERR400, "GLOBAL.FIELD_REQUIRED"),
    LENGTH_ERROR(HttpStatus.BAD_REQUEST, 0, Constants.CTBERR400, "GLOBAL.LENGTH_ERROR"),
    CODE_FIELD_REQUIRED(HttpStatus.BAD_REQUEST, 0, Constants.CTBERR400, "GLOBAL.CODE_FIELD_REQUIRED"),
    FORBIDDEN(HttpStatus.FORBIDDEN, 0, Constants.CTBERR403, "GLOBAL.FORBIDDEN"),
    NO_MATCH(HttpStatus.BAD_REQUEST, 0, Constants.CTBERR400, "GLOBAL.NO_MATCH"),
    NOT_PERMISSION(HttpStatus.BAD_REQUEST, 0, Constants.CTBERR400, "GLOBAL.NOT_PERMISSION"),
    SYMBOL_NOT_EXIST(HttpStatus.BAD_REQUEST, 0, Constants.CTBERR400, "GLOBAL.SYMBOL_NOT_EXIST"),
    ;

    private final HttpStatus httpStatus;
    private final int status;
    private final String code;
    private final String message;

    ApiResponseCode(HttpStatus httpStatus, int status, String code, String message) {
        this.httpStatus = httpStatus;
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
