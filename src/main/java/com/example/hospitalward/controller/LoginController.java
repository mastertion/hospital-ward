package com.example.hospitalward.controller;

import com.example.hospitalward.common.RestResponse;
import com.example.hospitalward.common.RestResponse.Builder;
import com.example.hospitalward.constants.OAuthConstant.Code;
import com.example.hospitalward.model.Staff;
import com.example.hospitalward.service.LoginUserService;
import com.example.hospitalward.util.JwtUtils;
import com.example.hospitalward.util.ServerResult;
import com.example.hospitalward.vo.StaffVO;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author likai
 * @Date 2018/10/18
 */
@RestController
public class LoginController {

  @Autowired
  private LoginUserService loginUserService;


  @PostMapping("/login")
  public RestResponse<String> login(@NotNull Staff staff) {
    String cardId = staff.getCardId();
    String password = staff.getPassword();
    String md5Password = DigestUtils.md5DigestAsHex((cardId+password).getBytes());
    if (StringUtils.isEmpty(cardId) || StringUtils.isEmpty(password)) {
      RestResponse.Builder builder = new Builder();
      builder.setMsg("账号和密码不能为空!");
      builder.setCode(Code.BUSINESS_ERROR);
      return builder.build();
    }
    StaffVO staffVO = loginUserService.findByCardId(cardId);

    if (null == staffVO || !staffVO.getPassword().equals(md5Password)) {
      throw new UnknownAccountException("用户名和密码错误");
    }
    String msg = "登录成功,请妥善保管您的token,有效期5分钟!";
    return RestResponse.OK(JwtUtils.createToken(staffVO), staffVO);
  }

  @GetMapping("/verify")
  public ServerResult verify() {
    try {
      Boolean result  = loginUserService.verify();
      return ServerResult.ok().put("data", result);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ServerResult.error();
  }
}
