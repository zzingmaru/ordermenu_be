package com.miniproject.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miniproject.api.CommonResponse;
import com.miniproject.api.menu.dto.CartRequest;
import com.miniproject.api.menu.dto.CartResponse;
import com.miniproject.api.menu.dto.MenuRequest;
import com.miniproject.api.menu.dto.MenuResponse;
import com.miniproject.common.ObjectMapperUtil;
import com.miniproject.mapper.menu.*;
import com.miniproject.service.MenuBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.TypeUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service("menuService")
public class MenuService implements MenuBaseService {

    final MenuMapper menuMapper;
    private final ObjectMapper objectMapper;

    public MenuService(MenuMapper menuMapper, ObjectMapper objectMapper) {
        this.menuMapper = menuMapper;
        this.objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }

    @Deprecated
    @Override
    public CommonResponse<List<MenuResponse>> find(String upperCd) {
        MenuEntity search = new MenuEntity();
        search.setUpperCd(upperCd);

        List<MenuResponse> menuResponses = ObjectMapperUtil.mapAll(
                menuMapper.find(search),
                MenuResponse.class
        );

        return CommonResponse.<List<MenuResponse>>builder()
                .data(menuResponses)
                .build();
    }

    @Deprecated
    @Override
    public CommonResponse<List<MenuResponse>> findOption(String upperCd) {
        MenuEntity entity = new MenuEntity();
        entity.setUpperCd(upperCd);

        List<MenuResponse> menuResponses = ObjectMapperUtil.mapAll(
                menuMapper.findOption(),
                MenuResponse.class
        );

        // 각 메뉴 타입별로 옵션 disabled 처리
        switch (entity.getUpperCd()) {
            case "AMERICANO":
            case "ESPRESSO":
            case "CAFE_LATTE":
            case "CAPPUCCINO":
                // 커피류는 모든 옵션 사용 가능 (HOT/ICE, LIGHT/THICK)
//                setOptionsAvailability(menuResponses, true, true, true, true);
                break;

            case "CHOCO":
            case "STRAWBERRY_LATTE":
                // 라떼류는 HOT/ICE만 가능, 농도 조절 불가
//                setOptionsAvailability(menuResponses, true, true, false, false);
                break;

            case "GRAPEFRUIT_ADE":
                // 에이드는 ICE만 가능, 농도 조절 가능
//                setOptionsAvailability(menuResponses, false, true, true, true);
                break;

            case "PEPPERMINT_TEA":
            case "CHAMOMILE_TEA":
            case "EARL_GRAY_TEA":
            case "ASSAM_TEA":
            case "DARJEELING_TEA":
                // 차류는 HOT/ICE 가능, 농도 조절 가능
//                setOptionsAvailability(menuResponses, true, true, false, false);
                break;
        }

        return CommonResponse.<List<MenuResponse>>builder()
                .data(menuResponses)
                .build();
    }

    @Override
    public CommonResponse<CartResponse> saveCart(CartRequest cartRequest) {
        log.info(String.valueOf(cartRequest));
        // request 값을 cartEntity 저장 - 가져온 값을 바로 사용하지 않고 확인 후 사용하려는 의도
        CartEntity cartEntity = objectMapper.convertValue(cartRequest, CartEntity.class);

        // orderNum 생성
        String orderNum = UUID.randomUUID().toString();
        cartEntity.getSelectMenu().setOrderNum(orderNum);

        // cartEntity null 확인
        log.info(cartEntity.toString());
        menuMapper.saveCart(cartEntity.getSelectMenu());
        if (cartEntity.getOptList() != null) {
            List<CartOptionEntity> cartOptionEntity = ObjectMapperUtil.mapAll(cartEntity.getOptList(), CartOptionEntity.class);

            for (CartOptionEntity opt : cartOptionEntity) {
                opt.setOrderNum(orderNum);
                menuMapper.saveOptionCart(opt);
            }
        }

        return CommonResponse.<CartResponse>builder()
                .data(objectMapper.convertValue(cartEntity, CartResponse.class))
                .build();
    }

    @Override
    public CommonResponse<List<CartResponse>> getCartList(String orderNum) {
        List<CartMenuEntity> list = menuMapper.findCartList(orderNum);
        log.info("list" + list);

//        list.forEach(cartMenuEntity -> {
//            CartResponse cartResponse = objectMapper.convertValue(cartMenuEntity, CartResponse.class);
//            Colletion.
//        });

//        List<CartResponse> cartResponses = objectMapper.convertValue(list, CartResponse.class)
//        log.info("cartResponses" + cartResponses);
//
//        return CommonResponse.<List<CartResponse>>builder().data(cartResponses).build();
        return null;
    }

    // 옵션 활성화/비활성화 설정 메소드
//    private void setOptionsAvailability(List<MenuResponse> responses,
//                                        boolean hotEnabled,
//                                        boolean iceEnabled,
//                                        boolean lightEnabled,
//                                        boolean thickEnabled) {
//        for (MenuResponse response : responses) {
//            switch (response.getMenuCd()) {
//                case "HOT_OPT":
//                case "HOT":
//                    response.setDisabled(!hotEnabled);
//                    break;
//                case "ICE_OPT":
//                case "ICE":
//                    response.setDisabled(!iceEnabled);
//                    break;
//                case "LIGHT":
//                    response.setDisabled(!lightEnabled);
//                    break;
//                case "THICK":
//                    response.setDisabled(!thickEnabled);
//                    break;
//            }
//        }
//    }
}
