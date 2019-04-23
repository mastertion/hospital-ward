package com.example.hospitalward.controller;

import com.example.hospitalward.model.LogHistory;
import com.example.hospitalward.model.Menu;
import com.example.hospitalward.model.PositionMenu;
import com.example.hospitalward.service.LogHistoryService;
import com.example.hospitalward.service.MenuService;
import com.example.hospitalward.util.ServerResult;
import com.example.hospitalward.vo.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/menu")
    @ResponseBody
    public ServerResult edit(Menu menu) {
        try {
           Boolean result = menuService.edit(menu);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }
    @PostMapping("/menu")
    @ResponseBody
    public ServerResult create(Menu menu) {
        try {
            Boolean result = menuService.create(menu);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }
    @DeleteMapping("/menu")
    @ResponseBody
    public ServerResult delete(Menu menu) {
        try {
            menu.setIsDeleted(true);
            Boolean result = menuService.edit(menu);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }
    @GetMapping("/position_menu")
    @ResponseBody
    public ServerResult getPositionMenu(Integer position) {
        try {
            PositionMenu positionMenu = menuService.getPositionMenu(position);
            return  ServerResult.ok().put("data",positionMenu );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }

    @PutMapping("/position_menu")
    @ResponseBody
    public ServerResult edit(PositionMenu positionMenu) {
        try {
            Boolean result = menuService.editPositionMenu(positionMenu);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }
    @PostMapping("/position_menu")
    @ResponseBody
    public ServerResult create(PositionMenu positionMenu) {
        try {
            Boolean result = menuService.createPositionMenu(positionMenu);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }
}
