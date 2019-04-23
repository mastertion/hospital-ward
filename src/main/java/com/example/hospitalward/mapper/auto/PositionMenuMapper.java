package com.example.hospitalward.mapper.auto;

import com.example.hospitalward.model.PositionMenu;
import com.example.hospitalward.model.PositionMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionMenuMapper {
    long countByExample(PositionMenuExample example);

    int deleteByExample(PositionMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PositionMenu record);

    int insertSelective(PositionMenu record);

    List<PositionMenu> selectByExample(PositionMenuExample example);

    PositionMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PositionMenu record, @Param("example") PositionMenuExample example);

    int updateByExample(@Param("record") PositionMenu record, @Param("example") PositionMenuExample example);

    int updateByPrimaryKeySelective(PositionMenu record);

    int updateByPrimaryKey(PositionMenu record);
}