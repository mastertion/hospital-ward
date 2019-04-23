package com.example.hospitalward.service;

import com.example.hospitalward.model.Bed;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.vo.BedAndRoomTree;
import com.example.hospitalward.vo.BedAndRoomVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BedService {
    PageInfo selectList(Bed bed, Page page) throws Exception;

    List<BedAndRoomTree> getBedAndRoomTree(BedAndRoomVO bedAndRoomVO) throws Exception;
}
