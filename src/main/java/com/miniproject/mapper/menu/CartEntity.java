package com.miniproject.mapper.menu;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.miniproject.api.menu.dto.CartRequest;
import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("CartEntity")
public class CartEntity {
//    private String cartSeq;
//    private String orderNum;
//
//    @JsonProperty("code")
//    private String menuCd;
//
//    @JsonProperty("name")
//    private String menuCdName;
//
//    @JsonProperty("price")
//    private String cost;

    @JsonAlias("selectMenu")
    private CartMenuEntity selectMenu;

    @JsonAlias("selectedOptions")
    private List<CartOptionEntity> optList;
}
