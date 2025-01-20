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

    @JsonProperty("selectMenu")
    private CartMenuEntity selectMenu;

    @JsonProperty("selectedOptions")
    private List<CartOptionEntity> optList;
}
