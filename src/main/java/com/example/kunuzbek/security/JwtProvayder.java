package com.example.kunuzbek.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtProvayder {

    private static final long extraTime = 1000*60*60*24*10; // 10 kunlik

    private static final  String secretKey = "MusobekQudratov2016";


    public String generateToken(
            String userName){

        Date expireDate = new Date(System.currentTimeMillis() + extraTime);

        return Jwts
                .builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    //token aynan yaroqli va bzniki ekanligini tekshirish
    public boolean validateToken(String token) {
        try {
            Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public  String getUserNameFromToken(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

        }catch (Exception e) {
            return null;
        }
    }
}
