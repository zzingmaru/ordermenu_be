package com.miniproject.mapper.menu;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuEntity> find(MenuEntity entity);

    List<MenuEntity> findOption();
}
