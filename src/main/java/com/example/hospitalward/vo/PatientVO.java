package com.example.hospitalward.vo;

import com.example.hospitalward.model.Patient;
import lombok.Data;

import java.util.Date;

@Data
public class PatientVO extends Patient {
    private String  staffName;
    private Integer roomNum;//房间号
    private Integer roomType;//房间类型 有0：大床房 1：单人房 2：双人房
    private String bedNum;//床位编号A 、B
}