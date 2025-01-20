package com.miniproject.api.menu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartResponse {
    private String orderNum;
    private String code;
    private String name;
    private Double price;
    private List<CartRequest.Opt> opt;

    @Getter
    @Setter
    public static class Opt{
        private String code;
        private String name;
        private String price;
    }
}
