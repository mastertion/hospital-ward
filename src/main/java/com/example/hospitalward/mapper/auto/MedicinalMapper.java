package com.example.hospitalward.mapper.auto;

import com.example.hospitalward.model.Medicinal;
import com.example.hospitalward.model.MedicinalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MedicinalMapper {
    long countByExample(MedicinalExample example);

    int deleteByExample(MedicinalExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Medicinal record);

    int insertSelective(Medicinal record);

    List<Medicinal> selectByExample(MedicinalExample example);

    Medicinal selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Medicinal record, @Param("example") MedicinalExample example);

    int updateByExample(@Param("record") Medicinal record, @Param("example") MedicinalExample example);

    int updateByPrimaryKeySelective(Medicinal record);

    int updateByPrimaryKey(Medicinal record);
}