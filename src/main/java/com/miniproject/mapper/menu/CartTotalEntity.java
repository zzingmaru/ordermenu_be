package com.miniproject.mapper.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("CartTotalEntity")
public class CartTotalEntity {

    @JsonProperty("selectMenu")
    private List<CartMenuEntity> selectMenu;

    private String orderNum;
}
