package com.example.hospitalward.mapper.auto;

import com.example.hospitalward.model.CarePlan;
import com.example.hospitalward.model.CarePlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarePlanMapper {
    long countByExample(CarePlanExample example);

    int deleteByExample(CarePlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CarePlan record);

    int insertSelective(CarePlan record);

    List<CarePlan> selectByExample(CarePlanExample example);

    CarePlan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CarePlan record, @Param("example") CarePlanExample example);

    int updateByExample(@Param("record") CarePlan record, @Param("example") CarePlanExample example);

    int updateByPrimaryKeySelective(CarePlan record);

    int updateByPrimaryKey(CarePlan record);
}