package com.example.hospitalward.service.impl;

import com.example.hospitalward.mapper.auto.MenuMapper;
import com.example.hospitalward.mapper.auto.PositionMenuMapper;
import com.example.hospitalward.mapper.custom.MenuCustomMapper;
import com.example.hospitalward.model.Menu;
import com.example.hospitalward.model.PositionMenu;
import com.example.hospitalward.model.PositionMenuExample;
import com.example.hospitalward.service.MenuService;
import com.example.hospitalward.util.SnowflakeIdWorker;
import com.example.hospitalward.vo.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuCustomMapper menuCustomMapper;

    @Autowired
    private PositionMenuMapper positionMenuMapper;
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

    @Override
    public Boolean edit(Menu menu) throws Exception {
        menu.setUpdateDate(new Date());
        int i = menuCustomMapper.updateByPrimaryKeySelective(menu);
        return true;
    }

    @Override
    public Boolean create(Menu menu) throws Exception {
        menu.setId(SnowflakeIdWorker.getUUID());
        menu.setCreateDate(new Date());
        menu.setUpdateDate(new Date());
        menu.setIsDeleted(false);
        int i = menuCustomMapper.insertSelective(menu);
        return true;
    }

    @Override
    public PositionMenu getPositionMenu(Integer position) throws Exception {
        if (position!= null) {
            PositionMenuExample example = new PositionMenuExample();
            example.createCriteria().andPositionEqualTo(position).andIsDeletedEqualTo(false);
            List<PositionMenu> positionMenus = positionMenuMapper.selectByExample(example);
            if (positionMenus != null && positionMenus.size() > 0) {
                PositionMenu positionMenu = positionMenus.get(0);
                return positionMenu;
            }
        }
        return null;
    }

    @Override
    public Boolean editPositionMenu(PositionMenu positionMenu) throws Exception {
        positionMenu.setUpdateDate(new Date());
        positionMenuMapper.updateByPrimaryKeySelective(positionMenu);
        return true;
    }

    @Override
    public Boolean createPositionMenu(PositionMenu positionMenu) throws Exception {
        positionMenu.setUpdateDate(new Date());
        positionMenu.setCreateDate(new Date());
        positionMenuMapper.insertSelective(positionMenu);
        return true;
    }
}
