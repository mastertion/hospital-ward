package com.example.hospitalward.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.hospitalward.model.Staff;
import com.example.hospitalward.vo.StaffVO;

import java.util.Date;

/**
 * @author likai
 * @Date 2018/10/18
 */
public class JwtUtils {

  private static final long EXPIRE_TIME = 5 * 60 * 1000;

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

  public static boolean verify(String cardId, String dbPwd, String token) {
    Algorithm algorithm = Algorithm.HMAC256(dbPwd);
    JWTVerifier jwtVerifier = JWT.require(algorithm)
            .withClaim(CLAIM_CARD_ID, cardId).build();
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
    return JWT.create()
            .withClaim(CLAIM_CARD_ID, staffVO.getCardId())
            .withExpiresAt(date)
            .sign(algorithm);

  }
}