package com.example.hospitalward.service;

import com.example.hospitalward.model.Staff;
import com.example.hospitalward.util.Page;
import com.github.pagehelper.PageInfo;

public interface StaffService {
    PageInfo list(Staff staff, Page page) throws Exception;

    Staff edit(Staff staff) throws Exception;

    Staff create(Staff staff) throws Exception;
}
