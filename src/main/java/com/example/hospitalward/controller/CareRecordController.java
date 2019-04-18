package com.example.hospitalward.controller;

import com.example.hospitalward.model.CareRecord;
import com.example.hospitalward.service.CareRecordService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.ServerResult;
import com.example.hospitalward.vo.CareRecordVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("product")
public class CareRecordController {
    @Autowired
    private CareRecordService careRecordService;

    @GetMapping("/careRecord")
    @ResponseBody
    public ServerResult list(CareRecordVO careRecord, Page page) {
        try {
            PageInfo list = careRecordService.list(careRecord, page);
            return  ServerResult.ok().put("data",list );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }

    @PostMapping("/careRecord")
    @ResponseBody
    public ServerResult create(@RequestBody CareRecordVO careRecord ) {
        try {
            Integer result = careRecordService.create(careRecord);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
    @PutMapping("/careRecord")
    @ResponseBody
    public ServerResult edit(@RequestBody CareRecordVO careRecord ) {
        try {
            Integer result = careRecordService.edit(careRecord);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
    @PutMapping("/careRecord/changeComplete")
    @ResponseBody
    public ServerResult update(CareRecord  careRecord ) {
        try {
            Integer result = careRecordService.update(careRecord);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
}
