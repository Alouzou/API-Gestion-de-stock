package com.example.gestiondestock.utils;

import com.example.gestiondestock.dto.auth.AuthenticationResponse;
import com.example.gestiondestock.model.auth.ExtendedUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {
    private String SECRET_KEY = "85ecc9a1210d4agdb4s6554dfs692b8da61a51d085ecc9a1210d4afa92892b8da61a51d0Ahk";

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);

    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);

    }

    public String extractIdEntreprise(String token) {
        final Claims claims = extractAllClaims(token);

        return claims.get("idEntreprise", String.class);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }


    private boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());
    }

    public String generateToken(ExtendedUser userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails);
    }

    private String createToken(Map<String, Object> claims, ExtendedUser userDetails) {

        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .claim("idEntreprise", userDetails.getIdEntreprise().toString())
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


//    public String unTokenBidon() {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("role", "user");
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject("userTesteur")
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//
//
//    }
}
