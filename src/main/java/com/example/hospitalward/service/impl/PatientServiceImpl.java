package com.example.hospitalward.service.impl;

import com.example.hospitalward.mapper.auto.PatientMapper;
import com.example.hospitalward.mapper.custom.BedCustomMapper;
import com.example.hospitalward.mapper.custom.PatientCustomMapper;
import com.example.hospitalward.model.Bed;
import com.example.hospitalward.model.Patient;
import com.example.hospitalward.model.PatientExample;
import com.example.hospitalward.service.PatientService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.vo.PatientVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientCustomMapper patientCustomMapper;
    @Autowired
    private BedCustomMapper bedCustomMapper;

    @Override
    public PageInfo list(Patient patient, Page page) {
        if(page!=null && page.getPageNum()!=null && page.getPageSize()!=null){
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }
        PatientExample example = new PatientExample();

        if (null != page && !StringUtils.isEmpty(page.getClause())) {
            example.setOrderByClause(page.getClause());
        }
        PatientExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        if (!StringUtils.isEmpty(patient.getName())) {
            criteria.andNameLike("%" + patient.getName() + "%");
        }

        List<Patient> patients = patientCustomMapper.selectByExample(example);
        PageInfo<Patient> pageInfo = new PageInfo<>(patients);
        return pageInfo;
    }
    @Override
    public PageInfo selectList(Patient patient, Page page) {
        if(page!=null && page.getPageNum()!=null && page.getPageSize()!=null){
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }
        if (!StringUtils.isEmpty(patient.getName())) {
            patient.setName("%" + patient.getName() + "%");
        }
        List<Patient> patients = patientCustomMapper.selectList(patient, page);
        PageInfo<Patient> pageInfo = new PageInfo<>(patients);
        return pageInfo;
    }

    @Override
    public Integer create(Patient patient) throws Exception {
        patient.setIsDeleted(false);
        patient.setOnHere(false);
        patient.setCreateDate(new Date());
        patient.setUpdateDate(new Date());
        patient.setCreateStaff(1l);
        int result = patientCustomMapper.insertSelective(patient);
        return result;
    }

    @Override
    public Integer edit(Patient patient) throws Exception {
        patient.setUpdateDate(new Date());
        patient.setCreateStaff(1l);
        int result = patientCustomMapper.updateByPrimaryKeySelective(patient);
        return result;
    }

    @Override
    public List selectListNotAccount(Patient patient) throws Exception {
        if (!StringUtils.isEmpty(patient.getName())) {
            patient.setName("%" + patient.getName() + "%");
        }
        if (!StringUtils.isEmpty(patient.getCardId())) {
            patient.setCardId("%" + patient.getCardId() + "%");
        }
        List<Patient> patients = patientCustomMapper.selectListNotAccount(patient);

        return patients;
    }

    @Override
    public List selectListNotCareRecord(Patient patient) throws Exception {
        if (!StringUtils.isEmpty(patient.getName())) {
            patient.setName("%" + patient.getName() + "%");
        }
        if (!StringUtils.isEmpty(patient.getCardId())) {
            patient.setCardId("%" + patient.getCardId() + "%");
        }
        List<Patient> patients = patientCustomMapper.selectListNotCareRecord(patient);

        return patients;
    }

    @Override
    public PageInfo selectListReserve(Patient patient, Page page) throws Exception {
        if(page!=null && page.getPageNum()!=null && page.getPageSize()!=null){
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }
        if (!StringUtils.isEmpty(patient.getName())) {
            patient.setName("%" + patient.getName() + "%");
        }
        List<Patient> patients = patientCustomMapper.selectListReserve(patient, page);
        PageInfo<Patient> pageInfo = new PageInfo<>(patients);
        return pageInfo;
    }

    @Override
    public PageInfo selectListCheckIn(Patient patient, Page page) throws Exception {
        if(page!=null && page.getPageNum()!=null && page.getPageSize()!=null){
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }
        if (!StringUtils.isEmpty(patient.getName())) {
            patient.setName("%" + patient.getName() + "%");
        }
        List<Patient> patients = patientCustomMapper.selectListCheckIn(patient, page);
        PageInfo<Patient> pageInfo = new PageInfo<>(patients);
        return pageInfo;
    }

    @Override
    public Boolean checkInPatient(PatientVO patientVO) throws Exception {
       if ( patientVO != null &&  patientVO.getBedId() != null) {
           Bed bed = new Bed();
           bed.setId(patientVO.getBedId());
           bed.setIsNull(true);
           bed.setStatus(false);
           bed.setUpdateDate(new Date());
           int i = bedCustomMapper.updateByPrimaryKeySelective(bed);
           return true;
       }
        return false;
    }

    @Override
    public Boolean cancelReserve(PatientVO patientVO) throws Exception {
        if ( patientVO != null &&  patientVO.getBedId() != null) {
            Bed bed = new Bed();
            bed.setId(patientVO.getBedId());
            bed.setIsNull(false);
            bed.setStatus(false);
            bed.setUpdateDate(new Date());
            int i = bedCustomMapper.updateByPrimaryKeySelective(bed);
            Patient patient = patientCustomMapper.selectByPrimaryKey(patientVO.getId());
            patient.setUpdateDate(new Date());
            patient.setBedId(null);
            int i1 = patientCustomMapper.updateByPrimaryKey(patient);
            return true;
        }
        return false;
    }

    @Override
    public List selectListNotCheckInAndReserve(Patient patient) throws Exception {
        if (!StringUtils.isEmpty(patient.getName())) {
            patient.setName("%" + patient.getName() + "%");
        }
        if (!StringUtils.isEmpty(patient.getCardId())) {
            patient.setCardId("%" + patient.getCardId() + "%");
        }
        List<Patient> patients = patientCustomMapper.selectListNotCheckInAndReserve(patient);

        return patients;
    }
}
