package com.miniproject.api.menu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartResponse {
    private CartRequest.SelectMenu selectMenu;
    private List<CartRequest.Opt> selectedOptions;
    private String orderNum;
}
