package com.example.hospitalward.service.impl;

import com.example.hospitalward.mapper.auto.CarePlanMapper;
import com.example.hospitalward.mapper.custom.AccountCustomerMapper;
import com.example.hospitalward.mapper.custom.MedicinalCustomMapper;
import com.example.hospitalward.model.Account;
import com.example.hospitalward.model.CarePlan;
import com.example.hospitalward.model.CarePlanExample;
import com.example.hospitalward.model.Medicinal;
import com.example.hospitalward.service.CarePlanService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.ServerResult;
import com.example.hospitalward.vo.AccountVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class CarePlanServiceImpl implements CarePlanService {
    @Autowired
    private CarePlanMapper carePlanMapper;
    @Autowired
    private MedicinalCustomMapper medicinalCustomMapper;
    @Autowired
    private AccountCustomerMapper accountCustomerMapper;
    @Override
    public PageInfo list(CarePlan carePlan, Page page) throws Exception {
        if(page!=null && page.getPageNum()!=null && page.getPageSize()!=null){
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }
        CarePlanExample example = new CarePlanExample();
        if (null != page && !StringUtils.isEmpty(page.getClause())) {
            example.setOrderByClause(page.getClause());
        }
        CarePlanExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        if (carePlan.getCareId() != null) {
            criteria.andCareIdEqualTo(carePlan.getCareId());
        }
        List<CarePlan> carePlans = carePlanMapper.selectByExample(example);
        PageInfo<CarePlan> pageInfo = new PageInfo<>(carePlans);
        return pageInfo;
    }

    @Override
    @Transactional
    public ServerResult update(CarePlan carePlan) throws Exception {
        if (carePlan.getIsComplete()){
            if (carePlan.getMedicinalId() != null && carePlan.getPatientId() != null) {
                Medicinal medicinal = medicinalCustomMapper.selectByPrimaryKey(carePlan.getMedicinalId());
                AccountVO accountVO = accountCustomerMapper.selecByPatientId(carePlan.getPatientId());
                if (medicinal != null && medicinal.getNumber() >= carePlan.getMedicinalNum()  ) {
                    if (accountVO != null) {
                        if (medicinal.getPrice()*carePlan.getMedicinalNum() < accountVO.getDeposit()) {
                            Account account = new Account();
                            BeanUtils.copyProperties(accountVO,account);
                            medicinal.setNumber(medicinal.getNumber()-carePlan.getMedicinalNum());
                            medicinal.setUpdateDate(new Date());
                            account.setDeposit(accountVO.getDeposit() - medicinal.getPrice() * carePlan.getMedicinalNum());
                            account.setMedicinesConsumption(accountVO.getDailyConsumption() + medicinal.getPrice() * carePlan.getMedicinalNum());
                            account.setUpdateDate(new Date());
                            medicinalCustomMapper.updateByPrimaryKeySelective(medicinal);
                            accountCustomerMapper.updateByPrimaryKeySelective(account);
                            carePlan.setUpdateDate(new Date());
                            carePlanMapper.updateByPrimaryKeySelective(carePlan);
                            return ServerResult.ok();
                        } else {
                            return  ServerResult.error(304,"用户账户余额不足");
                        }
                    }else {
                        return  ServerResult.error(304,"此用户无账户");
                    }

                } else {
                    return  ServerResult.error(304,"药品数量不足");
                }
            } else {
                carePlan.setUpdateDate(new Date());
                carePlanMapper.updateByPrimaryKeySelective(carePlan);
                return ServerResult.ok();            }

        } else {
            carePlan.setUpdateDate(new Date());
            carePlanMapper.updateByPrimaryKeySelective(carePlan);
            return ServerResult.ok();
        }

    }

}
