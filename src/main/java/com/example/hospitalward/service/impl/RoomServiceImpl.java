package com.example.hospitalward.service.impl;

import com.example.hospitalward.mapper.auto.RoomMapper;
import com.example.hospitalward.mapper.custom.BedCustomMapper;
import com.example.hospitalward.model.Account;
import com.example.hospitalward.model.Bed;
import com.example.hospitalward.model.Room;
import com.example.hospitalward.model.RoomExample;
import com.example.hospitalward.service.RoomService;
import com.example.hospitalward.util.LogHistoryUtils;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.SnowflakeIdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private BedCustomMapper bedCustomMapper;
    @Override
    public PageInfo selectList(Room room, Page page) throws Exception {
        if(page!=null && page.getPageNum()!=null && page.getPageSize()!=null){
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }
        RoomExample example = new RoomExample();
        RoomExample.Criteria criteria = example.createCriteria();

        List<Room> rooms = roomMapper.selectByExample(example);
        PageInfo<Room> pageInfo = new PageInfo<>(rooms);
        return pageInfo;
    }

    @Override
    public Room select(String roomNum) throws Exception {
        RoomExample example = new RoomExample();
        RoomExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(false).andRoomNumEqualTo(roomNum);
        List<Room> rooms = roomMapper.selectByExample(example);
        if (rooms != null && rooms.size() > 0) {
            return rooms.get(0);
        }
        return null;
    }

    @Override
    public Boolean create(Room room) throws Exception {
        if (room != null && room.getRoomType() != null && (room.getRoomType() == 1 || room.getRoomType() == 2 )) {
            room.setId(SnowflakeIdWorker.getUUID());
            room.setIsDeleted(false);
            room.setCreateDate(new Date());
            room.setUpdateDate(new Date());
            room.setCreateStaff(1L);
            Bed bed = new Bed();
            bed.setId(SnowflakeIdWorker.getUUID());
            bed.setRoomId(room.getId());
            bed.setBedNum("A");
            bed.setStatus(false);
            bed.setIsNull(false);
            bed.setIsDeleted(false);
            bed.setCreateDate(new Date());
            bed.setStaffId(1L);
            bed.setUpdateDate(new Date());
            bed.setCreateStaff(1L);
            bedCustomMapper.insertSelective(bed);
            if (room.getRoomType() == 2) {
                bed.setId(SnowflakeIdWorker.getUUID());
                bed.setBedNum("B");
                bedCustomMapper.insertSelective(bed);
            }
            roomMapper.insertSelective(room);
            LogHistoryUtils.log(room.getId().toString(), "创建房间信息及床位", room);
            return true;
        }
        return false;
    }
}
