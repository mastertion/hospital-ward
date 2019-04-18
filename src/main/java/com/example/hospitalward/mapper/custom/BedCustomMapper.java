package com.example.hospitalward.mapper.custom;

import com.example.hospitalward.model.Bed;
import com.example.hospitalward.model.BedExample;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.vo.BedAndRoomVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BedCustomMapper {
    List<BedAndRoomVO> selectList(@Param("bed")Bed bed, @Param("page") Page page);

}