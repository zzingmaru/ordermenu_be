package com.miniproject.exception;

import lombok.*;

import java.util.List;


@Builder
@Getter
@AllArgsConstructor
public class ErrorResponse {

    private int rsCode;
    private String rsMsg;
    private List<FieldError> errors;

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class FieldError {
        private String value;
        private String reason;

    }
}