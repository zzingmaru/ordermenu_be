package com.miniproject.mapper.menu;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("MenuEntity")
public class MenuEntity {
    private String menuCd;
    private String menuCdName;
    private String upperCd;
    private Double cost;
}
