package com.miniproject.mapper.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miniproject.api.menu.dto.CartRequest;
import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("CartOptionEntity")
public class CartOptionEntity {
    private String cartSeq;
    private String orderNum;

    @JsonProperty("code")
    private String menuCd;

    @JsonProperty("name")
    private String menuCdName;

    @JsonProperty("price")
    private double cost;

}
