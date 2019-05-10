package com.example.hospitalward.service.impl;

import com.example.hospitalward.mapper.auto.LogHistoryMapper;
import com.example.hospitalward.model.LogHistory;
import com.example.hospitalward.service.LogHistoryService;
import com.example.hospitalward.util.JwtUtils;
import com.example.hospitalward.util.SnowflakeIdWorker;
import com.example.hospitalward.vo.StaffVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogHistoryServiceImpl implements LogHistoryService {
    @Autowired
    private LogHistoryMapper logHistoryMapper;
    @Override
    public Boolean create(LogHistory logHistory) throws Exception {
        StaffVO userInfo = JwtUtils.getUserInfo();
        logHistory.setId(SnowflakeIdWorker.getUUID());
        logHistory.setCreateDate(new Date());
        logHistory.setUpdateDate(new Date());
        logHistory.setIsDeleted(false);
        logHistory.setCreateStaff(userInfo.getId());
        int i = logHistoryMapper.insert(logHistory);
        return true;
    }
}
