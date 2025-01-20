package com.miniproject.api.menu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartResponse {
    private SelectMenu selectMenu;
    private List<Opt> selectedOptions;

    @Getter
    @Setter
    public static class Opt{
        private String orderNum;
        private String code;
        private String name;
        private Double price;
    }

    @Getter
    @Setter
    public static class SelectMenu {
        private String orderNum;
        private String code;
        private String name;
        private Double price;
    }
}
