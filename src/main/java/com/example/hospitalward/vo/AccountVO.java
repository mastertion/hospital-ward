package com.example.hospitalward.vo;

import com.example.hospitalward.model.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.annotation.security.DenyAll;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
public class AccountVO extends Account {
    private String  staffName;
    private String patientName;
    private String cardId;
}