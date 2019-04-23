package com.example.hospitalward.mapper.auto;

import com.example.hospitalward.model.LogHistory;
import com.example.hospitalward.model.LogHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogHistoryMapper {
    long countByExample(LogHistoryExample example);

    int deleteByExample(LogHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LogHistory record);

    int insertSelective(LogHistory record);

    List<LogHistory> selectByExample(LogHistoryExample example);

    LogHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LogHistory record, @Param("example") LogHistoryExample example);

    int updateByExample(@Param("record") LogHistory record, @Param("example") LogHistoryExample example);

    int updateByPrimaryKeySelective(LogHistory record);

    int updateByPrimaryKey(LogHistory record);
}