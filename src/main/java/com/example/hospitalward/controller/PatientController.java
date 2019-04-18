package com.example.hospitalward.controller;

import com.example.hospitalward.model.Patient;
import com.example.hospitalward.service.PatientService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.ServerResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("customer")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/patient")
    @ResponseBody
    public ServerResult list(Patient patient, Page page) {
        try {
            PageInfo list = patientService.selectList(patient, page);
            return  ServerResult.ok().put("data",list );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
    @GetMapping("/patient_not_account")
    @ResponseBody
    public ServerResult list(Patient patient ) {
        try {
            List list = patientService.selectListtNotAccount(patient);
            return  ServerResult.ok().put("data",list );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }

    @GetMapping("/patient_not_care_record")
    @ResponseBody
    public ServerResult listPatient(Patient patient ) {
        try {
            List list = patientService.selectListtNotCareRecord(patient);
            return  ServerResult.ok().put("data",list );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
    @PostMapping("/patient")
    @ResponseBody
    public ServerResult create(Patient patient ) {
        try {
            Integer result = patientService.create(patient);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }

    @PutMapping("/patient")
    @ResponseBody
    public ServerResult edit(Patient patient ) {
        try {
            Integer result = patientService.edit(patient);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
}
