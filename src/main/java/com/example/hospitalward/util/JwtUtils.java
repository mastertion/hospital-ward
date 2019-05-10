package com.example.hospitalward.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.hospitalward.model.Staff;
import com.example.hospitalward.vo.StaffVO;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author likai
 * @Date 2018/10/18
 */
public class JwtUtils {

  private static final long EXPIRE_TIME = 5 * 60 * 1000;
  private static String header = "Authorization";
  private static String tokenHead = "Bearer ";

  private static final String CLAIM_CARD_ID = "cardId";

  public static String createToken(String cardId, String password) {
    Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
    //加密处理密码
    Algorithm algorithm = Algorithm.HMAC256(password);
    return JWT.create()
            .withClaim(CLAIM_CARD_ID, cardId)
            .withExpiresAt(date)
            .sign(algorithm);
  }

  public static boolean verify() {
    String token = resolveToken(getRequest());
    String userInfoString = getUserInfoString();
    StaffVO userInfo = getUserInfo();
    Algorithm algorithm = Algorithm.HMAC256(userInfo.getPassword());
    JWTVerifier jwtVerifier = JWT.require(algorithm)
            .withClaim(CLAIM_CARD_ID, userInfoString).build();
    try {
      jwtVerifier.verify(token);
    } catch (JWTVerificationException e) {
      return false;
    }
    return true;
  }

  public static String getCardId(String token) {
    try {
      DecodedJWT jwt = JWT.decode(token);
      return jwt.getClaim(CLAIM_CARD_ID).asString();
    } catch (JWTDecodeException e) {
      return null;
    }
  }

  public static String createToken(StaffVO staffVO) {
    Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
    //加密处理密码
    Algorithm algorithm = Algorithm.HMAC256(staffVO.getPassword());
    JSONObject object = JSONObject.fromObject(staffVO);
    String jsonstr = object.toString();
    return JWT.create()
            .withClaim(CLAIM_CARD_ID, jsonstr)
            .withExpiresAt(date)
            .sign(algorithm);

  }
  public static StaffVO getUserInfo() {
    String token = resolveToken(getRequest());

    try {
      DecodedJWT jwt = JWT.decode(token);
      JSONObject jsonObject=JSONObject.fromObject(jwt.getClaim(CLAIM_CARD_ID).asString());
      StaffVO staffVO=(StaffVO)JSONObject.toBean(jsonObject, StaffVO.class);
      return staffVO;
    } catch (JWTDecodeException e) {
      return null;
    }
  }
  public static String getUserInfoString() {
    String token = resolveToken(getRequest());

    try {
      DecodedJWT jwt = JWT.decode(token);
      return jwt.getClaim(CLAIM_CARD_ID).asString();
    } catch (JWTDecodeException e) {
      return null;
    }
  }

  private static String resolveToken(HttpServletRequest request) {
    String token = request.getHeader(header);

    if (StringUtils.isNotEmpty(token) && token.startsWith(tokenHead)) {
      token = token.substring(tokenHead.length());
    } else {
      token = null;
    }

    return token;
  }
  private static HttpServletRequest getRequest() {
    ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    return  servletRequestAttributes.getRequest();
  }
}