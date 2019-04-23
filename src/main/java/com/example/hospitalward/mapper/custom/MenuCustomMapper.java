package com.example.hospitalward.mapper.custom;

import com.example.hospitalward.mapper.auto.MenuMapper;
import com.example.hospitalward.model.Menu;
import com.example.hospitalward.vo.MenuTree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuCustomMapper extends MenuMapper {
    List<MenuTree> getMenuTree(@Param("position")Integer position);
    List<MenuTree> getAllMenuTree();

}
