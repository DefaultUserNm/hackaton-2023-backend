package ru.sbrf.hackaton.app.configuration.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;
import ru.sbrf.hackaton.app.exception.HackatonBaseException;
import ru.sbrf.hackaton.app.model.dto.ErrorInfo;

import java.util.Date;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static ru.sbrf.hackaton.app.exception.HackatonBaseExceptionCode.INTERNAL_ERROR;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
@ControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleControllerException(Exception ex, WebRequest request) {
        return handleException(ex, request, resolveStatus(ex));
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        log.error("Failed to complete request to '{}' with status: {}", getUri(request), statusCode);
        if (INTERNAL_SERVER_ERROR == statusCode) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(buildErrorInfo(ex, request), headers, statusCode);
    }

    private ResponseEntity<Object> handleException(Exception ex, WebRequest request, HttpStatus status) {
        log.error("Failed to complete request to '{}': {}", getUri(request), getStackTrace(ex));
        return new ResponseEntity<>(buildErrorInfo(ex, request), null, status);
    }

    private String getUri(WebRequest request) {
        return ((ServletWebRequest) request).getRequest().getRequestURI();
    }

    private HttpStatus resolveStatus(Exception ex) {
        ResponseStatus annotation = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
        return annotation != null ? annotation.code() : INTERNAL_SERVER_ERROR;
    }

    private ErrorInfo buildErrorInfo(Exception ex, WebRequest request) {
        HttpStatus status = resolveStatus(ex);
        return new ErrorInfo()
                .setTimestamp(new Date())
                .setStatus(status.value())
                .setError(ex.getMessage())
                .setPath(getUri(request))
                .setCode(resolveCode(ex));
    }

    private String resolveCode(Exception ex) {
        return (ex instanceof HackatonBaseException hbe)
                ? hbe.getCode()
                : INTERNAL_ERROR.name();
    }
}