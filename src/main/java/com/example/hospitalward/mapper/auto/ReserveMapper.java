package com.example.hospitalward.mapper.auto;

import com.example.hospitalward.model.Reserve;
import com.example.hospitalward.model.ReserveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReserveMapper {
    long countByExample(ReserveExample example);

    int deleteByExample(ReserveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Reserve record);

    int insertSelective(Reserve record);

    List<Reserve> selectByExample(ReserveExample example);

    Reserve selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Reserve record, @Param("example") ReserveExample example);

    int updateByExample(@Param("record") Reserve record, @Param("example") ReserveExample example);

    int updateByPrimaryKeySelective(Reserve record);

    int updateByPrimaryKey(Reserve record);
}