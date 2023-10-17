package com.goorm.arigonggan.common.exception;

import com.goorm.arigonggan.common.response.ErrorResponse;
import com.goorm.arigonggan.common.response.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ErrorController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BaseException.class)
    protected ResponseEntity<ErrorResponse> handleBaseException(BaseException e) {
        log.warn("message: {}, detail: {}", e.getErrorCode().getMessage(), e.getDetail(), e);
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(ResponseUtil.error(e.getErrorCode(), e.getDetail()));
    }
}