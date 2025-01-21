package com.miniproject.service;

import com.miniproject.api.CommonResponse;
import com.miniproject.api.menu.dto.*;

import java.util.List;

public interface MenuBaseService {

    CommonResponse<List<MenuResponse>> find(String upperCd);

    CommonResponse<List<MenuResponse>> findOption(String upperCd);

    CommonResponse<CartResponse> saveCart(CartRequest menuRequest);

    CommonResponse<List<CartTotalResponse>> getCartList(String orderNum);

    CommonResponse<Object> deleteMenuList(String[] seq);
}
