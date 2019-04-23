package com.example.hospitalward.service;

import com.example.hospitalward.model.Menu;
import com.example.hospitalward.model.PositionMenu;
import com.example.hospitalward.vo.MenuTree;

import java.util.List;

public interface MenuService {
    List<MenuTree> getMenuTree(Integer position) throws Exception;

    Boolean edit(Menu menu) throws Exception;

    Boolean create(Menu menu) throws Exception;

    PositionMenu getPositionMenu(Integer position) throws Exception;

    Boolean editPositionMenu(PositionMenu positionMenu) throws Exception;

    Boolean createPositionMenu(PositionMenu positionMenu) throws Exception;
}
