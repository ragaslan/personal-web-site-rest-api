package com.ragaslan.rest.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

public interface JWTService {

    String generateToken(String username);

    Key getKey();

    String extractUsername(String token);

    <T> T extractClaim(String token, Function<Claims,T> claimResolver);

    Claims extractAllClaims(String token);

    boolean validateToken(String token, UserDetails userDetails);

    boolean isTokenExpired(String token);

    Date extractExpiration(String token);

}
