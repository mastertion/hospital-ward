package com.example.hospitalward.service.impl;

import com.example.hospitalward.mapper.custom.BedCustomMapper;
import com.example.hospitalward.model.Bed;
import com.example.hospitalward.service.BedService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.vo.BedAndRoomTree;
import com.example.hospitalward.vo.BedAndRoomVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedServiceImpl implements BedService {
    @Autowired
    private BedCustomMapper bedCustomMapper;


    @Override
    public PageInfo selectList(Bed bed, Page page) {
        if(page!=null && page.getPageNum()!=null && page.getPageSize()!=null){
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }
        List<BedAndRoomVO> bedAndRoomVOS = bedCustomMapper.selectList(bed, page);
        PageInfo<BedAndRoomVO> pageInfo = new PageInfo<>(bedAndRoomVOS);
        return pageInfo;
    }

    @Override
    public  List<BedAndRoomTree> getBedAndRoomTree(BedAndRoomVO bedAndRoomVO) throws Exception {
        List<BedAndRoomTree> bedAndRoomTree = bedCustomMapper.getBedAndRoomTree(bedAndRoomVO);
        return bedAndRoomTree;
    }
}
