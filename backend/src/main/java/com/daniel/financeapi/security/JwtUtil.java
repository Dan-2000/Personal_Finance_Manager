package com.daniel.financeapi.security;

import java.security.Key;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;

@Component
public class JwtUtil {
    
@Value("${spring.jwt.secret}")
private String SECRET_KEY;

@Value("${spring.jwt.expiration}")
private long EXPIRATION_TIME;

private Key getSigningKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
}

public Claims extractAllClaims(String token) {
    return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
}
// generates a token based on the email as an identifier - gets current time and calculates based on the expiration time when it isn't valid anymore
public String generateToken(String email){
    return Jwts.builder().setSubject(email).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(getSigningKey()).compact();
}
public String extractEmail(String token) {
    return extractAllClaims(token).getSubject();
}
// checks if a token is valid
public boolean isTokenValid(String token) {
    try {
        extractAllClaims(token);
        return true; // Token is valid
    }
    catch (Exception e) {
        return false; // Token is invalid or expired
    }
}
}