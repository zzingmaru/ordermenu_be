package com.miniproject.api.menu;

import com.miniproject.api.CommonResponse;
import com.miniproject.api.menu.dto.MenuResponse;
import com.miniproject.service.MenuBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {

    final MenuBaseService menuService;

    public MenuController(MenuBaseService menuService) {
        this.menuService = menuService;
    }

    // 전체 메뉴 조회
    @GetMapping({""})
    CommonResponse<List<MenuResponse>> find(  @RequestParam(required = false) String upperCd) {
        return menuService.find(upperCd);
    }

    // 옵션 메뉴 조회
    @GetMapping({"/option"})
    CommonResponse<List<MenuResponse>> findOption(  @RequestParam(required = false) String upperCd) {
        return menuService.findOption(upperCd);
    }

}
