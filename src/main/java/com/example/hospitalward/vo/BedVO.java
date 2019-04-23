package com.example.hospitalward.vo;

import com.example.hospitalward.model.Bed;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BedVO extends Bed {
    private String name;
}
