package com.miniproject.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@Slf4j
@RestControllerAdvice
public class UseExceptionHandler extends ExceptionHandlerExceptionResolver {

    private static final String ERROR_LOG_INFO_LITERAL = "----%s-%s----";

    @ExceptionHandler({HttpMessageNotReadableException.class, HttpMediaTypeNotSupportedException.class})
    public ErrorResponse handleHttpExceptions(Exception e, HandlerMethod handlerMethod) {
        Class<?> errorClass = handlerMethod.getBeanType(); // 에러 발생 클래스
        String errorMethodName = handlerMethod.getMethod().getName(); // 에러 발생 메소드 명

        ErrorResponse message = ErrorResponse.builder()
                .rsCode(30001)
                .rsMsg("잘못된 접근입니다.")
                .build();

        log.info(String.format(ERROR_LOG_INFO_LITERAL, errorClass.getSimpleName(), errorMethodName));
        log.error("[HttpMessageNotReadableException]", e);
        return message;

    }

    @ExceptionHandler(UseException.class)
    public ErrorResponse simpleException(UseException e, HandlerMethod handlerMethod) {
        Class<?> errorClass = handlerMethod.getBeanType(); // 에러 발생 클래스
        String errorMethodName = handlerMethod.getMethod().getName(); // 에러 발생 메소드 명

        ErrorResponse message = ErrorResponse.builder()
                .rsCode(e.getRsCode())
                .rsMsg(e.getRsMsg())
                .build();

        log.info(String.format(ERROR_LOG_INFO_LITERAL, errorClass.getSimpleName(), errorMethodName));
        log.error("[UseException]", e);
        return message;

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponse illegalArgumentException(IllegalArgumentException e, HandlerMethod handlerMethod) {
        Class<?> errorClass = handlerMethod.getBeanType(); // 에러 발생 클래스
        String errorMethodName = handlerMethod.getMethod().getName(); // 에러 발생 메소드 명

        ErrorResponse message = ErrorResponse.builder()
                .rsCode(30002)
                .rsMsg("잘못된 값입니다.")
                .build();

        log.info(String.format(ERROR_LOG_INFO_LITERAL, errorClass.getSimpleName(), errorMethodName));
        log.error("[IllegalArgumentException]", e);
        return message;

    }

    @ExceptionHandler(DataAccessException.class)
    protected ErrorResponse dataAccessException(DataAccessException e, HandlerMethod handlerMethod) {
        Class<?> errorClass = handlerMethod.getBeanType(); // 에러 발생 클래스
        String errorMethodName = handlerMethod.getMethod().getName(); // 에러 발생 메소드 명

        ErrorResponse message = ErrorResponse.builder()
                .rsCode(30003)
                .rsMsg("서버 내 데이터 확인해주세요.")
                .build();

        log.info(String.format(ERROR_LOG_INFO_LITERAL, errorClass.getSimpleName(), errorMethodName));
        log.error("[DataAccessException]", e);
        return message;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorResponse dataIntegrityViolationException(DataIntegrityViolationException e, HandlerMethod handlerMethod) {
        Class<?> errorClass = handlerMethod.getBeanType(); // 에러 발생 클래스
        String errorMethodName = handlerMethod.getMethod().getName(); // 에러 발생 메소드 명

        ErrorResponse message = ErrorResponse.builder()
                .rsCode(30003)
                .rsMsg("서버 내 데이터 확인해주세요.")
                .build();

        log.info(String.format(ERROR_LOG_INFO_LITERAL, errorClass.getSimpleName(), errorMethodName));
        log.error("[DataIntegrityViolationException]", e);
        return message;

    }

    @ExceptionHandler(NullPointerException.class)
    public ErrorResponse nullPointerException(NullPointerException e, HandlerMethod handlerMethod) {
        Class<?> errorClass = handlerMethod.getBeanType(); // 에러 발생 클래스
        String errorMethodName = handlerMethod.getMethod().getName(); // 에러 발생 메소드 명

        ErrorResponse message = ErrorResponse.builder()
                .rsCode(30003)
                .rsMsg("데이터가 없습니다.")
                .build();

        log.info(String.format(ERROR_LOG_INFO_LITERAL, errorClass.getSimpleName(), errorMethodName));
        log.error("[NullPointerException]", e);
        return message;

    }

}
