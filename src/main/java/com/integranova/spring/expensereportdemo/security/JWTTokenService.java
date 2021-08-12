package com.integranova.spring.expensereportdemo.security;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import static org.apache.commons.lang3.StringUtils.substringBeforeLast;

import java.util.Date;
import java.util.Map;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableMap;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.compression.GzipCompressionCodec;

@Service
public class JWTTokenService implements Clock, TokenService {

    private static final String DOT = ".";
    private static final GzipCompressionCodec COMPRESSION_CODEC = new GzipCompressionCodec();

    private String issuer;
    private int expirationSec;
    private int clockSkewSec;
    String secretKey;

    public JWTTokenService(@Value("integranova") final String issuer, @Value("1800") final int expirationSec,
            @Value("300") final int clockSkewSec, @Value("secret") final String secret) {
        super();
        this.issuer = issuer;
        this.expirationSec = expirationSec;
        this.clockSkewSec = clockSkewSec;
        this.secretKey = secret;
    }

    @Override
    public String permanent(Map<String, String> attributes) {
        return newToken(attributes, 0);
    }

    @Override
    public String expiring(Map<String, String> attributes) {
        return newToken(attributes, expirationSec);
    }

    private String newToken(final Map<String, String> attributes, final int expiresInSec) {
        final Date now = now();
        final Claims claims = Jwts.claims().setIssuer(issuer).setIssuedAt(now);

        if (expiresInSec > 0) {
            final Date expiresAt = new Date(now.getTime() + (expiresInSec * 1000));
            claims.setExpiration(expiresAt);
        }
        claims.putAll(attributes);

        return Jwts.builder().setClaims(claims).signWith(HS256, secretKey).compressWith(COMPRESSION_CODEC).compact();
    }

    @Override
    public Map<String, String> untrusted(String token) {
        final JwtParser parser = Jwts.parser().requireIssuer(issuer).setClock(this)
                .setAllowedClockSkewSeconds(clockSkewSec).setSigningKey(secretKey);
        return parseClaims(() -> parser.parseClaimsJws(token).getBody());
    }

    @Override
    public Map<String, String> verify(String token) {
        final JwtParser parser = Jwts.parser().requireIssuer(issuer).setClock(this)
                .setAllowedClockSkewSeconds(clockSkewSec);
        final String withoutSignature = substringBeforeLast(token, DOT) + DOT;
        return parseClaims(() -> parser.parseClaimsJwt(withoutSignature).getBody());
    }

    private static Map<String, String> parseClaims(final Supplier<Claims> toClaims) {
        try {
            final Claims claims = toClaims.get();
            final ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
            for (final Map.Entry<String, Object> e : claims.entrySet()) {
                builder.put(e.getKey(), String.valueOf(e.getValue()));
            }
            return builder.build();
        } catch (final IllegalArgumentException | JwtException e) {
            return ImmutableMap.of();
        }
    }

    @Override
    public Date now() {
        return new Date(System.currentTimeMillis());
    }

}

