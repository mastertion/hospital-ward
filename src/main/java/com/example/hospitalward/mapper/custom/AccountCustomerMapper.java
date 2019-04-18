package com.example.hospitalward.mapper.custom;

import com.example.hospitalward.mapper.auto.AccountMapper;
import com.example.hospitalward.model.Account;
import com.example.hospitalward.model.AccountExample;
import com.example.hospitalward.model.Patient;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.vo.AccountVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountCustomerMapper extends AccountMapper {
    List<Account> selectList(@Param("patient")Patient patient, @Param("page") Page page);
    AccountVO selecByPatientId (Long patientId);
}