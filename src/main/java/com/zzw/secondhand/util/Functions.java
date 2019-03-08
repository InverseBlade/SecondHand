package com.zzw.secondhand.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zzw.secondhand.po.User;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

public class Functions {

    public static String md5(String raw, String salt) {
        return DigestUtils.md5DigestAsHex(
                (raw + salt).getBytes(StandardCharsets.UTF_8)
        );
    }

    public static String getToken(TokenInfo info) {
        return JWT.create()
                .withJWTId(String.valueOf(Math.random() * 99999))
                .withIssuer("secondhand")
                .withSubject(info.getUserName())
                .withClaim("uid", info.getUid())
                .withClaim("ip", info.getLoginIP())
                .withExpiresAt(info.getExpire())
                .sign(Algorithm.HMAC256(info.getSecret()));
    }

    public static User verifyToken(TokenInfo info) throws Exception {
        try {
            DecodedJWT decodedJWT = JWT.decode(info.getToken());

            String jwtId = decodedJWT.getId();
            String userName = decodedJWT.getSubject();
            Integer uid = decodedJWT.getClaim("uid").asInt();

            JWT.require(Algorithm.HMAC256(info.getSecret()))
                    .withJWTId(jwtId)
                    .withIssuer("secondhand")
                    .withSubject(userName)
                    .withClaim("uid", uid)
                    .withClaim("ip", info.getLoginIP())
                    .build()
                    .verify(info.getToken());
            return new User().setId(uid).setUserName(userName);
        } catch (Exception e) {
            throw new Exception("Verify Failed");
        }
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            //这个地方会有5s延迟
//			if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
//				//根据网卡取本机配置的IP
//				InetAddress inet=null;
//				try {
//					inet = InetAddress.getLocalHost();
//				} catch (UnknownHostException e) {
//					e.printStackTrace();
//				}
//				ipAddress= inet.getHostAddress();
//			}
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

}
