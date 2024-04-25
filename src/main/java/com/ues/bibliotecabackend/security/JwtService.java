package com.ues.bibliotecabackend.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtService {

  private static final String SECRET_KEY = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";
  private String token;

  public String getToken(UserDetails user) {
    return getToken(new HashMap<>(), user);
  }

  private String getToken(HashMap<String, Object> claims, UserDetails user) {
    return Jwts.builder()
        .setClaims(claims)
        .setSubject(user.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
        .signWith(getKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  public boolean isTokenValid(String token, UserDetails userDetails) {
    final String username = getCorreoFromToken(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

  public String getCorreoFromToken(String token) {
    if (token == null)
      return null;

    return getClaim(token, Claims::getSubject);
  }

  public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims getAllClaims(String token) {
    return Jwts
        .parserBuilder()
        .setSigningKey(getKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  private Date getExpiration(String token) {
    return getClaim(token, Claims::getExpiration);
  }

  private boolean isTokenExpired(String token) {
    return getExpiration(token).before(new Date());
  }

  private Key getKey() {
    byte[] secretBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(secretBytes);
  }
}
