package com.example.hospitalward.controller;

import com.example.hospitalward.model.Bed;
import com.example.hospitalward.model.Room;
import com.example.hospitalward.service.BedService;
import com.example.hospitalward.service.RoomService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.ServerResult;
import com.example.hospitalward.vo.BedAndRoomTree;
import com.example.hospitalward.vo.BedAndRoomVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("product")
public class BedController {
    @Autowired
    private BedService bedService;

    @Autowired
    private RoomService roomService;
    @GetMapping("/bed")
    @ResponseBody
    public ServerResult bed(Bed bed, Page page) {
        try {
            PageInfo accounts = bedService.selectList(bed, page);
            return  ServerResult.ok().put("data",accounts );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
    @PostMapping("/room")
    @ResponseBody
    public ServerResult create(Room room) {
        try {
            Boolean result = roomService.create(room);
            return  ServerResult.ok().put("data",result );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
    @GetMapping("/room")
    @ResponseBody
    public ServerResult room(Room room, Page page) {
        try {
            PageInfo accounts = roomService.selectList(room, page);
            return  ServerResult.ok().put("data",accounts );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
    @GetMapping("/room/{roomNum}")
    @ResponseBody
    public ServerResult room(@PathVariable ("roomNum") String roomNum ) {
        try {
            Room room = roomService.select(roomNum);
            return  ServerResult.ok().put("data",room );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
    @GetMapping("/BedAndRoomTree")
    @ResponseBody
    public ServerResult getBedAndRoomTree(BedAndRoomVO bedAndRoomVO) {
        try {
            List<BedAndRoomTree> bedAndRoomTree = bedService.getBedAndRoomTree(bedAndRoomVO);
            return  ServerResult.ok().put("data",bedAndRoomTree );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ServerResult.error();

    }
}
