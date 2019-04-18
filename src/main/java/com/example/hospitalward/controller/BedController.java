package com.example.hospitalward.controller;

import com.example.hospitalward.model.Bed;
import com.example.hospitalward.service.BedService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.ServerResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class BedController {
    @Autowired
    private BedService bedService;
    @GetMapping("/bed")
    @ResponseBody
    public ServerResult account(Bed bed, Page page) {
        PageInfo accounts = bedService.selectList(bed, page);
        return  ServerResult.ok().put("data",accounts );
    }
}
