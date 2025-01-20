package com.miniproject.mapper.menu;

import com.miniproject.api.menu.dto.CartRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuEntity> find(MenuEntity entity);

    List<MenuEntity> findOption();

    void saveCart(CartMenuEntity cartMenuEntity);

    void saveOptionCart(CartOptionEntity cartOptionEntity );

    List<CartMenuEntity> findCartList(String orderNum);
}
