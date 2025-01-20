package com.miniproject.api.menu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miniproject.mapper.menu.CartMenuEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartTotalResponse {
    @JsonProperty("selectMenu")
    private List<CartMenuEntity> selectMenu;

    private String orderNum;

    private String totalCost;
}
