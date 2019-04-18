package com.example.hospitalward.controller;

import com.example.hospitalward.model.Account;
import com.example.hospitalward.model.Patient;
import com.example.hospitalward.service.AccountService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.ServerResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @GetMapping("/account")
    @ResponseBody
    public ServerResult account(Patient patient, Page page) {
        try {
            PageInfo accounts = accountService.selectList(patient, page);
            return  ServerResult.ok().put("data",accounts );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
    @PostMapping("/account")
    @ResponseBody
    public ServerResult create(Account account) {
        try {
            Integer result = accountService.create(account);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
    @PutMapping("/account")
    @ResponseBody
    public ServerResult account(Account account) {

        try {
            Integer result  = accountService.edit(account);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();
    }
}
