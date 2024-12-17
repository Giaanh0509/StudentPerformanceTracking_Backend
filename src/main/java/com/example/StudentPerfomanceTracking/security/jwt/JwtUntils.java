package com.example.StudentPerfomanceTracking.security.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;


@Component
public class JwtUntils {
    @Value("${jwt.secret}")
    private String secretKey;

    private long expirationTime = 1000 * 60 * 60;

    // Tạo JWT token với thông tin username và role
    public String generateToken(String username, String role, int id) {
        SecretKey key =  Keys.hmacShaKeyFor(secretKey.getBytes());

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .claim("userId", id)// Thêm role vào payload
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    // Lấy role từ token

    // Kiểm tra tính hợp lệ của JWT token
    public boolean validateToken(String token, String username) {
        String tokenUsername = extractUsername(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    // Lấy username từ token
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Lấy role từ token
    public String extractRole(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);  // Lấy role từ claim
    }

    public int extractUserId(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey.getBytes())  // Chú ý dùng secret key để xác minh chữ ký của token
                .parseClaimsJws(token)
                .getBody()
                .get("userId", Integer.class);  // Lấy userId từ claim
    }

    // Kiểm tra xem token đã hết hạn chưa
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }

}
