package com.example.hospitalward.service;

import com.example.hospitalward.model.Patient;
import com.example.hospitalward.util.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PatientService {
    PageInfo list(Patient patient, Page page) throws Exception;

    PageInfo selectList(Patient patient, Page page) throws Exception;

    Integer create(Patient patient) throws Exception;

    Integer edit(Patient patient) throws Exception;

    List selectListtNotAccount(Patient patient) throws Exception;

    List selectListtNotCareRecord(Patient patient) throws Exception;
}
