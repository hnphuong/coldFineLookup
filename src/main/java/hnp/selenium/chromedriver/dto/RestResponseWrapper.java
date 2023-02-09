package hnp.selenium.chromedriver.dto;

import hnp.selenium.chromedriver.constant.enums.ApiResponseCode;
import hnp.selenium.chromedriver.exception.RestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

public final class RestResponseWrapper {
    private RestResponseWrapper() {
    }

    public static ResponseEntity<BodyResponseDTO<Object>> wrapInternalErrorResponse(String i18nMessage) {
        return getResponse(ApiResponseCode.UNKNOWN_ERROR.getHttpStatus(), ApiResponseCode.UNKNOWN_ERROR.getStatus(), ApiResponseCode.UNKNOWN_ERROR.getCode(), i18nMessage);
    }

    public static ResponseEntity<BodyResponseDTO<Object>> wrapInternalErrorResponseUA(String i18nMessage) {
        return getResponse(ApiResponseCode.FORBIDDEN.getHttpStatus(), ApiResponseCode.FORBIDDEN.getStatus(), ApiResponseCode.FORBIDDEN.getCode(), i18nMessage);
    }

    public static ResponseEntity<BodyResponseDTO<Object>> wrapInternalErrorResponse(RestException restException, String i18nMessage) {
        if (Objects.nonNull(restException.getParams())) {
            return getResponse(restException.getRestError().getHttpStatus(), restException.getRestError().getStatus(), restException.getRestError().getCode(), i18nMessage, restException.getParams()[0]);
        } else {
            return getResponse(restException.getRestError().getHttpStatus(), restException.getRestError().getStatus(), restException.getRestError().getCode(), i18nMessage);
        }
    }

    public static <T> ResponseEntity<BodyResponseDTO<T>> getResponse(HttpStatus httpStatus, int status, String code, String message) {
        BodyResponseDTO<T> bodyResponse = new BodyResponseDTO<>(status, code, message);
        return new ResponseEntity<>(bodyResponse, httpStatus);
    }

    public static <T> ResponseEntity<BodyResponseDTO<T>> getResponse(ApiResponseCode response,String message, T data) {
        BodyResponseDTO<T> bodyResponse = new BodyResponseDTO<>(response.getStatus(), response.getCode(), message, data);
        return new ResponseEntity<>(bodyResponse, HttpStatus.OK);
    }
    public static <T> ResponseEntity<BodyResponseDTO<T>> getResponse(HttpStatus httpStatus, int status, String code, String message, String detail) {
        BodyResponseDTO<T> bodyResponse = new BodyResponseDTO<>(status, code, message);
        if (Objects.nonNull(detail) && !detail.isEmpty() && !detail.trim().isBlank()) {
            bodyResponse = new BodyResponseDTO<T>(status, code, message, (T) detail);
        }
        return new ResponseEntity<>(bodyResponse, httpStatus);
    }
}
