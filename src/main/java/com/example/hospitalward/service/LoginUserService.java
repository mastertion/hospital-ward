package com.example.hospitalward.service;


import com.example.hospitalward.vo.StaffVO;

/**
 * @author likai
 * @Date 2018/10/18
 */
public interface LoginUserService {

  StaffVO findByCardId(String cardId);

}
