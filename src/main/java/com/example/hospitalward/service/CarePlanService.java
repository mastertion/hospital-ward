package com.example.hospitalward.service;

import com.example.hospitalward.model.CarePlan;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.ServerResult;
import com.github.pagehelper.PageInfo;

public interface CarePlanService {
    PageInfo list(CarePlan carePlan, Page page) throws Exception ;

    ServerResult update(CarePlan carePlan) throws Exception ;
}
