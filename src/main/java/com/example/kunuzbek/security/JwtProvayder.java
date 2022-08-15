package com.example.kunuzbek.security;

import com.example.kunuzbek.entity.Role;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Component
public class JwtProvayder {

    private static final long extraTime = 1000*60*60*24*10; // 10 kunlik

    private static final  String secretKey = "MusobekQudratov2016";


    public String generateToken(Role roles, String userName){

        Date expireDate = new Date(System.currentTimeMillis() + extraTime);

        String token = Jwts
                .builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .claim("roles", roles)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
        return token;
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
            String userName = Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            return userName;

        }catch (Exception e) {
            return null;
        }
    }
}
