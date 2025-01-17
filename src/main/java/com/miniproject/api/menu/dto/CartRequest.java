package com.miniproject.api.menu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {
    private String menuCd;
    private String menuCdName;
    private String upperCd;
    private Double cost;
    private Opt opt;

    @Getter
    @Setter
    public static class Opt{
        private String menuCd;
        private String menuCdName;
    }
}
