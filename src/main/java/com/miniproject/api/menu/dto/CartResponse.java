package com.miniproject.api.menu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResponse {
    private String menuCd;
    private String menuCdName;
    private String upperCd;
    private Double cost;
    private CartRequest.Opt opt;

    private Boolean optYn;


}
