package com.example.hospitalward.vo;

import com.example.hospitalward.model.CarePlan;
import com.example.hospitalward.model.CareRecord;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class CareRecordVO extends CareRecord {

    private String  staffName;
    private String PatientName;
    private String cardId;

    private List<CarePlan> carePlanList;

}
