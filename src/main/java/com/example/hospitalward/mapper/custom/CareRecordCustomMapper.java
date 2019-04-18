package com.example.hospitalward.mapper.custom;

import com.example.hospitalward.mapper.auto.CareRecordMapper;
import com.example.hospitalward.model.CareRecord;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.vo.CareRecordVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CareRecordCustomMapper extends CareRecordMapper {
    List<CareRecord> selectList(@Param("careRecord") CareRecordVO careRecord, @Param("page") Page page);
}