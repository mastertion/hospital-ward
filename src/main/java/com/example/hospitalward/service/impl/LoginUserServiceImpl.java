package com.example.hospitalward.service.impl;

import com.example.hospitalward.constants.OAuthConstant;
import com.example.hospitalward.mapper.auto.StaffMapper;
import com.example.hospitalward.mapper.custom.MenuCustomMapper;
import com.example.hospitalward.model.Staff;
import com.example.hospitalward.model.StaffExample;
import com.example.hospitalward.service.LoginUserService;
import com.example.hospitalward.util.JwtUtils;
import com.example.hospitalward.vo.MenuTree;
import com.example.hospitalward.vo.StaffVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author likai
 * @Date 2018/10/18
 */
@Service
public class LoginUserServiceImpl implements LoginUserService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private MenuCustomMapper menuCustomMapper;
    @Override
    public StaffVO findByCardId(String cardId) {
        //写死验证业务
        StaffExample example = new StaffExample();
        example.createCriteria().andCardIdEqualTo(cardId).andIsDeletedEqualTo(false).andOntheJobEqualTo(true);
        List<Staff> staffList = staffMapper.selectByExample(example);
        if (staffList != null && staffList.size() > 0) {
            Staff staff = staffList.get(0);
            StaffVO staffVO = new StaffVO();
            BeanUtils.copyProperties(staff, staffVO);
            Set<String> roles = new LinkedHashSet<>();
            Set<String> permissions = new LinkedHashSet<>();
            List<MenuTree> menuTree;
            if (staff.getPosition() == 0) {
                menuTree = menuCustomMapper.getAllMenuTree();
            } else {
                menuTree = menuCustomMapper.getMenuTree(staff.getPosition());
            }
            staffVO.setMenu(menuTree);
            roles.add(OAuthConstant.Roles.ADMIN);
            permissions.add(OAuthConstant.Permissions.INSERT);
            staffVO.setRoles(roles);
            staffVO.setPermissions(permissions);
            return staffVO;
        }
        return null;
    }

    @Override
    public Boolean verify() throws Exception {
        return JwtUtils.verify();
    }
}
