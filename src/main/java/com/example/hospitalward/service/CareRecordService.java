package com.example.hospitalward.service;

import com.example.hospitalward.model.CareRecord;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.vo.CareRecordVO;
import com.github.pagehelper.PageInfo;

public interface CareRecordService {
    PageInfo list(CareRecordVO careRecord, Page page) throws Exception ;

    Integer create(CareRecordVO careRecord) throws Exception ;

    Integer edit(CareRecordVO careRecord) throws Exception ;

    Integer update(CareRecord careRecord) throws Exception ;

    Boolean delete(CareRecord careRecord) throws Exception ;
}
