package com.example.hospitalward.service;

import com.example.hospitalward.model.Bed;
import com.example.hospitalward.util.Page;
import com.github.pagehelper.PageInfo;

public interface BedService {
    PageInfo selectList(Bed bed, Page page);

}
