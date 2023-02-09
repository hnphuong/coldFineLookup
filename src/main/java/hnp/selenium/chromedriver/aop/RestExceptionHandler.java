package hnp.selenium.chromedriver.aop;

import hnp.selenium.chromedriver.constant.enums.ApiResponseCode;
import hnp.selenium.chromedriver.dto.BodyResponseDTO;
import hnp.selenium.chromedriver.dto.RestResponseWrapper;
import hnp.selenium.chromedriver.exception.RestException;
import hnp.selenium.chromedriver.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private final MessageUtils messageUtil;

    @ExceptionHandler(RestException.class)
    public ResponseEntity<BodyResponseDTO<Object>> handleRestException(HttpServletRequest request, RestException ex) {
        logger.error(ex.getMessage(), ex);
        String i18nMessage = messageUtil.populate(ex.getRestError().getMessage(), ex.getParams());
        return RestResponseWrapper.wrapInternalErrorResponse(ex, i18nMessage);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<BodyResponseDTO<Object>> handleAccessDeniedException(HttpServletRequest request, Exception ex) {
        logger.error(ex.getMessage(), ex);
        String i18nMessage = messageUtil.populate(ApiResponseCode.FORBIDDEN.getMessage());
        return RestResponseWrapper.wrapInternalErrorResponseUA(i18nMessage);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<BodyResponseDTO<Object>> handleUnCaughtException(HttpServletRequest request, Exception ex) {
        logger.error(ex.getMessage(), ex);
        String i18nMessage = messageUtil.populate(ApiResponseCode.UNKNOWN_ERROR.getMessage());
        return RestResponseWrapper.wrapInternalErrorResponse(i18nMessage);
    }
}
