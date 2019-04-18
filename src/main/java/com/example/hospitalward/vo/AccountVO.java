package com.example.hospitalward.vo;

import com.example.hospitalward.model.Account;
import lombok.Data;

import javax.annotation.security.DenyAll;
import java.util.Date;

@Data
public class AccountVO extends Account {
    private String  staffName;
    private String patientName;
    private String cardId;
}