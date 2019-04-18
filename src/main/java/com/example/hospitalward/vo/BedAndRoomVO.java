package com.example.hospitalward.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BedAndRoomVO {
    private int roomNum;//房间号
    private int roomType;//房间类型 有0：大床房 1：单人房 2：双人房
    private int bedId;//床位id 主键自增
    private int roomId;//房间id
    private String bedNum;//床位编号A 、B
    private int status;//有无预定 0：无预定 1：有预定
    private int isNull;//是否空床 0:为空床 1：为不空
    private int staffId;//入住管理id
    private String staffName;//入住管理id
    private Boolean isDeleted;

    private Date createDate;

    private Date updateDate;

    private Long createStaff;
}
