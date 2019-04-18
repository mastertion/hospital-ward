package com.example.hospitalward.service.impl;

import com.example.hospitalward.mapper.custom.MedicinalCustomMapper;
import com.example.hospitalward.model.Medicinal;
import com.example.hospitalward.service.MedicinalService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.SnowflakeIdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
@Service
public class MedicinalServiceImpl implements MedicinalService {
    @Autowired
    private MedicinalCustomMapper medicinalCustomMapper;
    @Override
    public PageInfo list(Medicinal medicinal, Page page) throws Exception {
        if(page!=null && page.getPageNum()!=null && page.getPageSize()!=null){
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }

        if (!StringUtils.isEmpty(medicinal.getName())) {
            medicinal.setName("%" + medicinal.getName() + "%");
        }
        List<Medicinal> medicinals = medicinalCustomMapper.selectList(medicinal,page);
        PageInfo<Medicinal> pageInfo = new PageInfo<>(medicinals);
        return pageInfo;
    }

    @Override
    public Integer create(Medicinal medicinal) throws Exception {
        medicinal.setId(SnowflakeIdWorker.getUUID());
        medicinal.setCreateDate(new Date());
        medicinal.setRegistrationDate(new Date());
        medicinal.setUpdateDate(new Date());
        medicinal.setIsDeleted(false);
        int result = medicinalCustomMapper.insertSelective(medicinal);
        return result;
    }

    @Override
    public Integer edit(Medicinal medicinal) throws Exception {
        medicinal.setUpdateDate(new Date());
        medicinal.setIsDeleted(false);
        int result = medicinalCustomMapper.updateByPrimaryKeySelective(medicinal);
        return result;
    }
}