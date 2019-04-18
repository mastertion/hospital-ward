package com.example.hospitalward.mapper.auto;

import com.example.hospitalward.model.CareRecord;
import com.example.hospitalward.model.CareRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CareRecordMapper {
    long countByExample(CareRecordExample example);

    int deleteByExample(CareRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CareRecord record);

    int insertSelective(CareRecord record);

    List<CareRecord> selectByExample(CareRecordExample example);

    CareRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CareRecord record, @Param("example") CareRecordExample example);

    int updateByExample(@Param("record") CareRecord record, @Param("example") CareRecordExample example);

    int updateByPrimaryKeySelective(CareRecord record);

    int updateByPrimaryKey(CareRecord record);
}