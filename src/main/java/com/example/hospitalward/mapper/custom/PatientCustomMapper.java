package com.example.hospitalward.mapper.custom;

import com.example.hospitalward.mapper.auto.PatientMapper;
import com.example.hospitalward.model.Patient;
import com.example.hospitalward.model.PatientExample;
import com.example.hospitalward.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientCustomMapper extends PatientMapper {
    List<Patient> selectList(@Param("patient")Patient patient, @Param("page") Page page);

    List<Patient> selectListNotAccount(Patient patient);

    List<Patient> selectListNotCareRecord(Patient patient);

    List<Patient> selectListReserve(@Param("patient")Patient patient, @Param("page") Page page);

    List<Patient> selectListCheckIn(@Param("patient")Patient patient, @Param("page") Page page);

    List<Patient> selectListNotCheckInAndReserve(Patient patient);


}