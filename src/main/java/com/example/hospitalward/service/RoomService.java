package com.example.hospitalward.service;

import com.example.hospitalward.model.Room;
import com.example.hospitalward.util.Page;
import com.github.pagehelper.PageInfo;

public interface RoomService {
    PageInfo selectList(Room room, Page page) throws Exception;

    Room select(String roomNum) throws Exception;

    Boolean create(Room room) throws Exception;
}
