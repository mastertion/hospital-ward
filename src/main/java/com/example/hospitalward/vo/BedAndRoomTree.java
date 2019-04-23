package com.example.hospitalward.vo;

import com.example.hospitalward.model.Room;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@Data
@EqualsAndHashCode(callSuper=false)
public class BedAndRoomTree extends Room {
    private String name;
    private List<BedVO> children;
}
