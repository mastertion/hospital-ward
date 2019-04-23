package com.example.hospitalward.service;

import com.example.hospitalward.vo.MenuTree;

import java.util.List;

public interface MenuService {
    List<MenuTree> getMenuTree(Integer position) throws Exception;

}
