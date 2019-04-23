package com.example.hospitalward.controller;

import com.example.hospitalward.model.LogHistory;
import com.example.hospitalward.service.LogHistoryService;
import com.example.hospitalward.service.MenuService;
import com.example.hospitalward.util.ServerResult;
import com.example.hospitalward.vo.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping()
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/menu_tree")
    @ResponseBody
    public ServerResult getMenuTree(Integer position) {
        try {
            List<MenuTree> menuTree = menuService.getMenuTree(position);
            return  ServerResult.ok().put("data",menuTree );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
}
