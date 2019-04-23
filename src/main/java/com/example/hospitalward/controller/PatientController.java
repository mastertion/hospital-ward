package com.example.hospitalward.controller;

import com.example.hospitalward.model.Patient;
import com.example.hospitalward.service.PatientService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.ServerResult;
import com.example.hospitalward.vo.PatientVO;
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

    /**
     *  分页查询用户信息
     * @param patient
     * @param page
     * @return
     */
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

    /**
     *  查询没有账户的用户信息
     * @param patient
     * @return
     */
    @GetMapping("/patient_not_account")
    @ResponseBody
    public ServerResult list(Patient patient ) {
        try {
            List list = patientService.selectListNotAccount(patient);
            return  ServerResult.ok().put("data",list );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }

    /**
     * 查询入住没有制定计划的用户
     * @param patient
     * @return
     */
    @GetMapping("/patient_not_care_record")
    @ResponseBody
    public ServerResult listPatient(Patient patient ) {
        try {
            List list = patientService.selectListNotCareRecord(patient);
            return  ServerResult.ok().put("data",list );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }

    /**
     * 添加用户基本信息
     * @param patient
     * @return
     */
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

    /**
     * 修改用户基本信息
     * @param patient
     * @return
     */
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

    /**
     *  查询预定的用户
     * @param patient
     * @param page
     * @return
     */
    @GetMapping("/patient_reserve")
    @ResponseBody
    public ServerResult selectListReserve(Patient patient, Page page) {
        try {
            PageInfo list = patientService.selectListReserve(patient, page);
            return  ServerResult.ok().put("data",list );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
    /**
     *  预订房间
     * @param patient
     * @return
     */
    @PutMapping("/patient_reserve")
    @ResponseBody
    public ServerResult patientReserve(Patient patient ) {
        try {
            Boolean result = patientService.patientReserve(patient);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }

    /**
     *  入住房间
     * @param patient
     * @return
     */
    @PutMapping("/patient_check_in")
    @ResponseBody
    public ServerResult patientCheckIn(Patient patient ) {
        try {
            Boolean result = patientService.patientCheckIn(patient);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
    /**
     * 查询入住的用户
     * @param patient
     * @param page
     * @return
     */
    @GetMapping("/patient_check_in")
    @ResponseBody
    public ServerResult selectListCheckIn(Patient patient, Page page) {
        try {
            PageInfo list = patientService.selectListCheckIn(patient, page);
            return  ServerResult.ok().put("data",list );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }

    /**
     * 修改用户的基本信息 入住
     * @param patientVO
     * @return
     */
    @PutMapping("/patient_to_check_in")
    @ResponseBody
    public ServerResult checkInPatient(PatientVO patientVO) {
        try {
            Boolean result = patientService.checkInPatient(patientVO);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }

    /**
     *  取消用户入住
     * @param patientVO
     * @return
     */
    @PutMapping("/patient_cancel_reserve")
    @ResponseBody
    public ServerResult cancelReserve(PatientVO patientVO) {
        try {
            Boolean result = patientService.cancelReserve(patientVO);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }

    /**
     * 查询没有预定入住的信息
     * @param patient
     * @return
     */
    @GetMapping("/patient_not_check_in_reserve")
    @ResponseBody
    public ServerResult selectListNotChecInAndReserve(Patient patient ) {
        try {
            List list = patientService.selectListNotCheckInAndReserve(patient);
            return  ServerResult.ok().put("data",list );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
}
