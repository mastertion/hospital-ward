package com.example.hospitalward.mapper.custom;

import com.example.hospitalward.mapper.auto.MedicinalMapper;
import com.example.hospitalward.model.Medicinal;
import com.example.hospitalward.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicinalCustomMapper extends MedicinalMapper {
    List<Medicinal> selectList(@Param("medicinal")Medicinal medicinal, @Param("page")Page page);

}
