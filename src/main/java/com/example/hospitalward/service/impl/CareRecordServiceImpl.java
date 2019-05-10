package com.example.hospitalward.service.impl;

import com.example.hospitalward.mapper.auto.CarePlanMapper;
import com.example.hospitalward.mapper.custom.CareRecordCustomMapper;
import com.example.hospitalward.model.CarePlan;
import com.example.hospitalward.model.CarePlanExample;
import com.example.hospitalward.model.CareRecord;
import com.example.hospitalward.service.CareRecordService;
import com.example.hospitalward.util.JwtUtils;
import com.example.hospitalward.util.LogHistoryUtils;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.SnowflakeIdWorker;
import com.example.hospitalward.vo.CareRecordVO;
import com.example.hospitalward.vo.StaffVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class CareRecordServiceImpl implements CareRecordService {
    @Autowired
    private CareRecordCustomMapper careRecordCustomMapper;

    @Autowired
    private CarePlanMapper carePlanMapper;
    @Override
    public PageInfo list(CareRecordVO careRecord, Page page) throws Exception {

        if(page!=null && page.getPageNum()!=null && page.getPageSize()!=null){
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }
        if (!StringUtils.isEmpty(careRecord.getStaffName())) {
            careRecord.setStaffName("%" + careRecord.getStaffName() + "%");
        }
        if (!StringUtils.isEmpty(careRecord.getPatientName())) {
            careRecord.setPatientName("%" + careRecord.getPatientName() + "%");
        }
        List<CareRecord> careRecords = careRecordCustomMapper.selectList(careRecord, page);
        PageInfo<CareRecord> pageInfo = new PageInfo<>(careRecords);
        return pageInfo;
    }

    @Override
    @Transactional
    public Integer create(CareRecordVO careRecordVO) throws Exception {
        StaffVO userInfo = JwtUtils.getUserInfo();

        CareRecord careRecord = new CareRecord();
        BeanUtils.copyProperties(careRecordVO, careRecord);
        careRecord.setId(SnowflakeIdWorker.getUUID());
        List<CarePlan> carePlanList = careRecordVO.getCarePlanList();
        if (carePlanList != null) {
            for (CarePlan carePlan:  carePlanList ) {
                if (carePlan!= null) {
                    carePlan.setId(SnowflakeIdWorker.getUUID());
                    carePlan.setPatientId(careRecordVO.getPatientId());
                    carePlan.setCareId(careRecord.getId());
                    carePlan.setIsComplete(false);
                    carePlan.setIsDeleted(false);
                    carePlan.setCreateDate(new Date());
                    carePlan.setUpdateDate(new Date());
                    carePlan.setCreateStaff(userInfo.getId());
                    carePlanMapper.insertSelective(carePlan);
                }
            }
        }
        careRecord.setIsComplete(false);
        careRecord.setIsDeleted(false);
        careRecord.setCreateDate(new Date());
        careRecord.setUpdateDate(new Date());
        careRecord.setCreateStaff(userInfo.getId());
        int result = careRecordCustomMapper.insertSelective(careRecord);
        LogHistoryUtils.log(careRecord.getId().toString() , "制定计划", careRecordVO);
        return result;
    }

    @Override
    @Transactional
    public Integer edit(CareRecordVO careRecordVO) throws Exception {
        StaffVO userInfo = JwtUtils.getUserInfo();
        CarePlan delCarePlan = new CarePlan();
        delCarePlan.setIsDeleted(true);
        CarePlanExample example = new CarePlanExample();
        example.createCriteria().andCareIdEqualTo(careRecordVO.getId());
        int i = carePlanMapper.updateByExampleSelective(delCarePlan, example);
        CareRecord careRecord = new CareRecord();
        BeanUtils.copyProperties(careRecordVO, careRecord);
        List<CarePlan> carePlanList = careRecordVO.getCarePlanList();
        if (carePlanList != null) {
            for (CarePlan carePlan:  carePlanList ) {
                if (carePlan!= null && carePlan.getId() != null) {
                    carePlan.setIsComplete(false);
                    carePlan.setIsDeleted(false);
                    carePlan.setUpdateDate(new Date());
                    carePlan.setCreateStaff(userInfo.getId());
                    carePlanMapper.updateByPrimaryKeySelective(carePlan);
                } else {
                    carePlan.setId(SnowflakeIdWorker.getUUID());
                    carePlan.setPatientId(careRecordVO.getPatientId());
                    carePlan.setCareId(careRecord.getId());
                    carePlan.setIsComplete(false);
                    carePlan.setIsDeleted(false);
                    carePlan.setCreateDate(new Date());
                    carePlan.setUpdateDate(new Date());
                    carePlan.setCreateStaff(userInfo.getId());
                    carePlanMapper.insertSelective(carePlan);
                }
            }
        }
        careRecord.setIsComplete(false);
        careRecord.setIsDeleted(false);
        careRecord.setUpdateDate(new Date());
        careRecord.setCreateStaff(userInfo.getId());
        int result = careRecordCustomMapper.updateByPrimaryKeySelective(careRecord);
        LogHistoryUtils.log(careRecord.getId().toString() , "更新计划", careRecordVO);
        return result;
    }

    @Override
    public Integer update(CareRecord careRecord) throws Exception {
        careRecord.setUpdateDate(new Date());
        int result = careRecordCustomMapper.updateByPrimaryKeySelective(careRecord);
        return result;
    }

    @Override
    public Boolean delete(CareRecord careRecord) throws Exception {
        careRecord.setUpdateDate(new Date());
        careRecord.setIsDeleted(true);
        int result = careRecordCustomMapper.updateByPrimaryKeySelective(careRecord);
        return  1 == result ? true : false;
    }
}
