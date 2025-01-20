package com.miniproject.api.menu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FinalCartResponse {
    private String cartSeq;
    private String orderNum;
    private String menuCd;
    private String menuCdName;
    private String cost;
    private String optionYn;
    private String totalCost;

}
