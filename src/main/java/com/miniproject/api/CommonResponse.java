package com.miniproject.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {

    @Builder.Default int rsCode = 200;
    @Builder.Default String rsMsg = "SUCCESS";

    private T data;

}