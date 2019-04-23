package com.example.hospitalward.service.impl;

import com.example.hospitalward.mapper.auto.MenuMapper;
import com.example.hospitalward.mapper.custom.MenuCustomMapper;
import com.example.hospitalward.service.MenuService;
import com.example.hospitalward.vo.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuCustomMapper menuCustomMapper;
    @Override
    public List<MenuTree> getMenuTree(Integer position) throws Exception {
        List<MenuTree> menuTree;
        if (position != null) {
            menuTree = menuCustomMapper.getMenuTree(position);
        } else {
            menuTree = menuCustomMapper.getAllMenuTree();

        }
        return menuTree;
    }
}
