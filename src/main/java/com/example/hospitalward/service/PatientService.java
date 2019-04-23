package com.example.hospitalward.service;

import com.example.hospitalward.model.Patient;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.vo.PatientVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PatientService {
    PageInfo list(Patient patient, Page page) throws Exception;

    PageInfo selectList(Patient patient, Page page) throws Exception;

    Integer create(Patient patient) throws Exception;

    Integer edit(Patient patient) throws Exception;

    List selectListNotAccount(Patient patient) throws Exception;

    List selectListNotCareRecord(Patient patient) throws Exception;

    PageInfo selectListReserve(Patient patient, Page page) throws Exception;

    PageInfo selectListCheckIn(Patient patient, Page page) throws Exception;

    Boolean checkInPatient(PatientVO patientVO) throws Exception;

    Boolean cancelReserve(PatientVO patientVO) throws Exception;

    List selectListNotCheckInAndReserve(Patient patient) throws Exception;

    Boolean patientReserve(Patient patient) throws Exception;

    Boolean patientCheckIn(Patient patient) throws Exception;
}
