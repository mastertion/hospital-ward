package com.example.hospitalward.vo;

import com.example.hospitalward.model.Medicinal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MedicinalVO extends Medicinal {
    private String  staffName;
    private String PatientName;

}
