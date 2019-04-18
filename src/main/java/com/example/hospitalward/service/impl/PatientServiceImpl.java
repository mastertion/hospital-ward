package com.example.hospitalward.service.impl;

import com.example.hospitalward.mapper.auto.PatientMapper;
import com.example.hospitalward.mapper.custom.PatientCustomMapper;
import com.example.hospitalward.model.Patient;
import com.example.hospitalward.model.PatientExample;
import com.example.hospitalward.service.PatientService;
import com.example.hospitalward.util.Page;
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
    public List selectListtNotAccount(Patient patient) throws Exception {
        if (!StringUtils.isEmpty(patient.getName())) {
            patient.setName("%" + patient.getName() + "%");
        }
        if (!StringUtils.isEmpty(patient.getCardId())) {
            patient.setCardId("%" + patient.getCardId() + "%");
        }
        List<Patient> patients = patientCustomMapper.selectListtNotAccount(patient);

        return patients;
    }

    @Override
    public List selectListtNotCareRecord(Patient patient) throws Exception {
        if (!StringUtils.isEmpty(patient.getName())) {
            patient.setName("%" + patient.getName() + "%");
        }
        if (!StringUtils.isEmpty(patient.getCardId())) {
            patient.setCardId("%" + patient.getCardId() + "%");
        }
        List<Patient> patients = patientCustomMapper.selectListtNotCareRecord(patient);

        return patients;
    }
}
