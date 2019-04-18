package com.example.hospitalward.controller;

import com.example.hospitalward.model.CarePlan;
import com.example.hospitalward.service.CarePlanService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.ServerResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("product")

public class CarePlanController {
    @Autowired
    private CarePlanService carePlanService;
    @GetMapping("/carePlan")
    @ResponseBody
    public ServerResult list(CarePlan carePlan, Page page) {
        try {
            PageInfo list = carePlanService.list(carePlan, page);
            return  ServerResult.ok().put("data",list );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }

    @PutMapping("/carePlan")
    @ResponseBody
    public ServerResult carePlan(CarePlan carePlan) {
        try {
            ServerResult serverResult = carePlanService.update(carePlan);
            return  serverResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
}
