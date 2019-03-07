package com.zzw.secondhand.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zzw.secondhand.po.User;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Functions {

    public static String md5(String raw, String salt) {
        return DigestUtils.md5DigestAsHex(
                (raw + salt).getBytes(StandardCharsets.UTF_8)
        );
    }

    public static String getToken(User user, Date expire, String secret) {
        return JWT.create()
                .withJWTId(String.valueOf(Math.random() * 99999))
                .withIssuer("secondhand")
                .withSubject(user.getUserName())
                .withClaim("uid", user.getId())
                .withExpiresAt(expire)
                .sign(Algorithm.HMAC256(secret));
    }

    public static User verifyToken(String token, String secret) throws Exception {
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            String jwtId = decodedJWT.getId();

            User user = new User();
            user.setUserName(decodedJWT.getSubject());
            user.setId(decodedJWT.getClaim("uid").asInt());

            JWT.require(Algorithm.HMAC256(secret))
                    .withJWTId(jwtId)
                    .withIssuer("secondhand")
                    .withSubject(user.getUserName())
                    .withClaim("uid", user.getId())
                    .build()
                    .verify(token);
            return user;
        } catch (Exception e) {
            throw new Exception("Verify Failed");
        }
    }

}
