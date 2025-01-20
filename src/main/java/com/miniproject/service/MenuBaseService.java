package com.miniproject.service;

import com.miniproject.api.CommonResponse;
import com.miniproject.api.menu.dto.CartRequest;
import com.miniproject.api.menu.dto.CartResponse;
import com.miniproject.api.menu.dto.MenuRequest;
import com.miniproject.api.menu.dto.MenuResponse;

import java.util.List;

public interface MenuBaseService {

    CommonResponse<List<MenuResponse>> find(String upperCd);

    CommonResponse<List<MenuResponse>> findOption(String upperCd);

    CommonResponse<CartResponse> saveCart(CartRequest menuRequest);
}
