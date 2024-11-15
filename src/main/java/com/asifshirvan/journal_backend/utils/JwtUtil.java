package com.asifshirvan.journal_backend.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private String SECRET_KEY = "0U5CBERQOnBuTL+8OMKwAJt7/LOLmXFM4oHGVQisCXJKTBushYx8VwXKh9GP9hYOecIviRYSe/lvUGjfdhf9wjFKcNr7VtM3IIekj65urGDD4wSanzSk5OqlpKKBupJbvJi75jRMlTSiGNkoo1C/fNRpG9wOKQCPzUlAAcfUxmYMoGh9TjqhbMnkBDF0ZWyrd3hpFo3USLp4VnN2XvP+lJCiScdQ2hUPVFxVxWpFxegCjbHwSen3Tr4lijJDF1dk4Gj9EmrIybQInjQXG19OHzXURlElb2022+FbANqufOm+Q6/OjHY2Iezv/gaHbNQDIhYwT7HwFPV6nM1l1JeS+hRHjJEkQlkGrBpFvErFXEQ="; // TODO: Change this to a more secure secret key

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
