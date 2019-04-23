package com.example.hospitalward.controller;

import com.example.hospitalward.model.LogHistory;
import com.example.hospitalward.service.LogHistoryService;
import com.example.hospitalward.util.ServerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("log")
public class LogHistoryController {
    @Autowired
    private LogHistoryService logHistoryService;
    @PostMapping("/log_history")
    @ResponseBody
    public ServerResult create(LogHistory logHistory) {
        try {
            Boolean result = logHistoryService.create(logHistory);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
}
