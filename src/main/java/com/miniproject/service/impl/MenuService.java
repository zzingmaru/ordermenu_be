package com.miniproject.service.impl;

import com.miniproject.api.CommonResponse;
import com.miniproject.api.menu.dto.MenuResponse;
import com.miniproject.common.ObjectMapperUtil;
import com.miniproject.mapper.menu.MenuEntity;
import com.miniproject.mapper.menu.MenuMapper;
import com.miniproject.service.MenuBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("menuService")
public class MenuService implements MenuBaseService {

    final MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

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
                setOptionsAvailability(menuResponses, true, true, true, true);
                break;

            case "CHOCO":
            case "STRAWBERRY_LATTE":
                // 라떼류는 HOT/ICE만 가능, 농도 조절 불가
                setOptionsAvailability(menuResponses, true, true, false, false);
                break;

            case "GRAPEFRUIT_ADE":
                // 에이드는 ICE만 가능, 농도 조절 가능
                setOptionsAvailability(menuResponses, false, true, true, true);
                break;

            case "PEPPERMINT_TEA":
            case "CHAMOMILE_TEA":
            case "EARL_GRAY_TEA":
            case "ASSAM_TEA":
            case "DARJEELING_TEA":
                // 차류는 HOT/ICE 가능, 농도 조절 가능
                setOptionsAvailability(menuResponses, true, true, false, false);
                break;
        }

        return CommonResponse.<List<MenuResponse>>builder()
                .data(menuResponses)
                .build();
    }

    // 옵션 활성화/비활성화 설정 메소드
    private void setOptionsAvailability(List<MenuResponse> responses,
                                        boolean hotEnabled,
                                        boolean iceEnabled,
                                        boolean lightEnabled,
                                        boolean thickEnabled) {
        for (MenuResponse response : responses) {
            switch (response.getMenuCd()) {
                case "HOT_OPT":
                case "HOT":
                    response.setDisabled(!hotEnabled);
                    break;
                case "ICE_OPT":
                case "ICE":
                    response.setDisabled(!iceEnabled);
                    break;
                case "LIGHT":
                    response.setDisabled(!lightEnabled);
                    break;
                case "THICK":
                    response.setDisabled(!thickEnabled);
                    break;
            }
        }
    }
}
