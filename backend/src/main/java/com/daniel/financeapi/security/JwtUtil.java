package com.daniel.financeapi.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import com.daniel.financeapi.UserRepository;

@Component
public class JwtUtil {
private final UserRepository userRepository;   

@Value("${spring.jwt.secret}")
private String SECRET_KEY;
//28800000 is 8H in milliseconds
public final long EXPIRATION_TIME = 28800000;

public Claims extractAllClaims(String token) {
    return Jwt.parseBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
}

}
