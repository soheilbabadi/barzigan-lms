package com.barzigan.www.barziganlms.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {

    public String extractUsername(String jwt) {

        return extractClaims(jwt, Claims::getSubject);
    }

    public String generateToken(Map<String, Object> extractClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 10))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public boolean isTokenValid(String jwt, UserDetails userDetails) {
        final String username = extractUsername(jwt);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
    }

    private Date extractExpiration(String jwt) {
        return extractClaims(jwt, Claims::getExpiration);
    }

    private boolean isTokenExpired(String jwt) {
        return extractExpiration(jwt).before(new Date());
    }

    public <T> T extractClaims(String jwt, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClams(jwt);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClams(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        String key = "bTuU2JY+EeuX8NoSbKMaWN2qESNMw1hzPh1HepD+Pe3qNZAwC541MihUJMYxqDojlzMNpND640hSFynKyLz7j0YbiyAlf6zXNqBk8UZvQxevO3YWbLar0kWZruceol5XcGYjwCxl6HxC1JUdgwTjuqV3PpYG+wrLQWJ4QABACeb6FnZQsqE1gAx4oK6DXqMxOeEB1W4WjHxmJ4Nt+dGMWKOC6HL5Czb3e7MehOxxlKreZTWNxNacaha30WQXMXH2Cms3btlXaX0PS7UBF08H4M6dQw48U4BKwqMdrDbarSsN+GwG08dx1rzqKza+0L5swX6y0ycb3esclvg1PFpSLntorcCUys6tOLfIY=";
        byte[] keyBytes = Decoders.BASE64.decode(key);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
