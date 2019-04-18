package com.example.hospitalward.controller;

import com.example.hospitalward.model.Medicinal;
import com.example.hospitalward.service.MedicinalService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.ServerResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("product")
public class MedicinalController {
    @Autowired
    private MedicinalService medicinalService;

    @GetMapping("/medicinal")
    @ResponseBody
    public ServerResult getById(Medicinal medicinal, Page page) {
        try {
            PageInfo list = medicinalService.list(medicinal, page);
            return  ServerResult.ok().put("data",list );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }

    @PostMapping("/medicinal")
    @ResponseBody
    public ServerResult create(Medicinal medicinal) {
        try {
            Integer result = medicinalService.create(medicinal);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }

    @PutMapping("/medicinal")
    @ResponseBody
    public ServerResult edit(Medicinal medicinal) {
        try {
            Integer result = medicinalService.edit(medicinal);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }
}
