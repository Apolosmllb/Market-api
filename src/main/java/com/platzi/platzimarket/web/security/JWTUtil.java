package com.platzi.platzimarket.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Date;

@Component
public class JWTUtil {
    private static final String KEY = "ApolosApolosApolosApolosApolosApolosApolosApolosApolosApolosApolosApolos";
    public String genereteToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+10000*60*60*10))
                .signWith(SignatureAlgorithm.HS256,KEY).compact();
    }
    public boolean validateToken(String token, UserDetails userDetails){
        return userDetails.getUsername().equals(extractUsername(token)) && !isTokenEspired(token);
    }

    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }
    public boolean isTokenEspired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();

    }
}
