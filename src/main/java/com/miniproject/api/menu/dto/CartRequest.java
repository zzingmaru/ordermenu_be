package com.miniproject.api.menu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartRequest {
//    private String code;
//    private String name;
//    private Double price;
    private SelectMenu selectMenu;
    private List<Opt> selectedOptions;

    @Getter
    @Setter
    public static class Opt{
        private String code;
        private String name;
        private Double price;
    }

    @Getter
    @Setter
    private static class SelectMenu {
        private String code;
        private String name;
        private Double price;
    }
}
