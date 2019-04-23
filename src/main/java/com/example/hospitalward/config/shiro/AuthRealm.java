package com.example.hospitalward.config.shiro;

import com.example.hospitalward.config.jwt.JwtToken;
import com.example.hospitalward.service.LoginUserService;
import com.example.hospitalward.util.JwtUtils;
import com.example.hospitalward.vo.StaffVO;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 参照jdbcRealm，实现自定义realm，主要完成shiro的登录和授权工作
 *
 * @author likai
 * @Date 2018/10/18
 */
public class AuthRealm extends AuthorizingRealm {

  @Autowired
  private LoginUserService loginUserService;

  /**
   * 设置realm支持的authenticationToken类型
   */
  @Override
  public boolean supports(AuthenticationToken token) {
    return null != token && token instanceof JwtToken;
  }

  /**
   * 登陆认证
   *
   * @param authenticationToken jwtFilter传入的token
   * @return 登陆信息
   * @throws AuthenticationException 未登陆抛出异常
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
          throws AuthenticationException {
    //getCredentials getPrincipal getToken 都是返回jwt生成的token串
    String token = (String) authenticationToken.getCredentials();

    String cardId = JwtUtils.getCardId(token);
    if (cardId == null) {
      throw new AccountException("token invalid");
    }
    //如果需要可以根据业务实现db操作,这里根据service写死
    StaffVO byCardId = loginUserService.findByCardId(cardId);
//    if (loginUser == null) {
//      throw new AuthenticationException("User didn't existed!");
//    }

    if (!JwtUtils.verify(cardId, byCardId.getPassword(), token)) {
      throw new UnknownAccountException("Username or password error");
    }

    return new SimpleAuthenticationInfo(token, token, getName());
  }

  /**
   * 授权认证
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    String token = principalCollection.toString();
    //根据token获取权限授权
    String cardId = JwtUtils.getCardId(token);
    StaffVO byCardId = loginUserService.findByCardId(cardId);
    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    authorizationInfo.setRoles(byCardId.getRoles());
    authorizationInfo.setStringPermissions(byCardId.getPermissions());
    return authorizationInfo;
  }
}
