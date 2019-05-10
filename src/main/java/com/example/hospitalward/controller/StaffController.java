package com.example.hospitalward.controller;

import com.example.hospitalward.model.Staff;
import com.example.hospitalward.service.StaffService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.ServerResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("customer")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/staff")
    @ResponseBody
    public ServerResult list(Staff staff, Page page) {
        try {
            PageInfo list = staffService.list(staff, page);
            return  ServerResult.ok().put("data",list );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }

    @PutMapping("/staff")
    @ResponseBody
    public ServerResult edit(Staff staff) {
        try {
            staff = staffService.edit(staff);
            return  ServerResult.ok().put("data",staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }

    @PostMapping("/staff")
    @ResponseBody
    public ServerResult create(Staff staff) {
        try {
            staff = staffService.create(staff);
            return  ServerResult.ok().put("data",staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }
    @PutMapping("/staff-password")
    @ResponseBody
    public ServerResult editPassword(Staff staff) {
        try {
            staff.setPassword(DigestUtils.md5DigestAsHex((staff.getCardId() + "123456").getBytes()));
            staff = staffService.edit(staff);
            return  ServerResult.ok().put("data",staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }
}
