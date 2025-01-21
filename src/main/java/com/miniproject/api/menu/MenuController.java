package com.miniproject.api.menu;

import com.miniproject.api.CommonResponse;
import com.miniproject.api.menu.dto.*;
import com.miniproject.service.MenuBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
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
    @Deprecated
    @GetMapping({""})
    CommonResponse<List<MenuResponse>> find(  @RequestParam(required = false) String upperCd) {
        return menuService.find(upperCd);
    }

    // 옵션 메뉴 조회
    @Deprecated
    @GetMapping({"/option"})
    CommonResponse<List<MenuResponse>> findOption(  @RequestParam(required = false) String upperCd) {
        return menuService.findOption(upperCd);
    }

    // 담은 메뉴 저장
    @PostMapping({"/cart"})
    CommonResponse<CartResponse> saveCart(@RequestBody CartRequest cartRequest){
        return menuService.saveCart(cartRequest);
    }
    
    // 장바구니 조회
    @GetMapping({"/cart-list"})
    CommonResponse<List<CartTotalResponse>> getCartList(@RequestParam(required = true) String orderNum){
        return menuService.getCartList(orderNum);
    }

    // 장바구니 삭제 (requestbody로 받을 수 없으므로 putmapping)
    @PutMapping({"/cart-list"})
    CommonResponse<Object> deleteMenuList(@RequestBody String[] seq){
    return menuService.deleteMenuList(seq);
    }

    


}
