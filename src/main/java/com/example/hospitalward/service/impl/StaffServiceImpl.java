package com.example.hospitalward.service.impl;

import com.example.hospitalward.mapper.auto.StaffMapper;
import com.example.hospitalward.model.Staff;
import com.example.hospitalward.model.StaffExample;
import com.example.hospitalward.service.StaffService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.SnowflakeIdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import org.springframework.util.DigestUtils;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public PageInfo list(Staff staff, Page page) throws Exception {
        if(page!=null && page.getPageNum()!=null && page.getPageSize()!=null){
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }
        StaffExample example = new StaffExample();
        if (null != page && !StringUtils.isEmpty(page.getClause())) {
            example.setOrderByClause(page.getClause());
        } else {
            example.setOrderByClause("update_date desc");
        }
        StaffExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        if (!StringUtils.isEmpty(staff.getName())) {
            criteria.andNameLike("%" + staff.getName() + "%");
        }
        if (staff.getPosition() != null) {
            criteria.andPositionEqualTo(staff.getPosition());
        }
        if (staff.getOntheJob() != null) {
            criteria.andOntheJobEqualTo(staff.getOntheJob());
        }
        List<Staff> staffList = staffMapper.selectByExample(example);
       PageInfo<Staff> pageInfo = new PageInfo<>(staffList);
        return pageInfo;
    }

    @Override
    public Staff edit(Staff staff) throws Exception {
        staff.setUpdateDate(new Date());
        staff.setUserName(staff.getName() + '(' + staff.getCardId() + ')');
        staff.setCreateStaff(1L);
        int i = staffMapper.updateByPrimaryKeySelective(staff);

        return staff;
    }
    @Override
    public Staff create(Staff staff) throws Exception {
        staff.setId(SnowflakeIdWorker.getUUID());
        staff.setUpdateDate(new Date());
        staff.setPassword(DigestUtils.md5DigestAsHex((staff.getCardId() + "123456").getBytes()));
        staff.setUserName(staff.getName() + '(' + staff.getCardId() + ')');
        staff.setCreateDate(new Date());
        staff.setIsDeleted(false);
        staff.setJobTime(new Date());
        staff.setOntheJob(true);
        staff.setCreateStaff(1L);
        int i = staffMapper.insertSelective(staff);
        return staff;
    }
}
