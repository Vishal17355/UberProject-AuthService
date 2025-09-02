package org.example.uberprojectauthservice.Services;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService implements   CommandLineRunner {

    @Value("${jwt.expiry}")
    private int expiry;


    @Value("${jwt.secret}")
    private String secret;
    private String createToken(Map<String, Object> payload , String UserName){// this method create a new token based on payload

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiry  * 1000L);
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .claims(payload)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expiryDate)
                .subject(UserName)
                .signWith(key)
                .compact();
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String,Object> mp = new HashMap<>();
        mp.put("email" , "a@b.com");
        mp.put("phoneNumber" , "123456789");


        String result = createToken( mp,"vishal");
        System.out.println("Generate tokeen is :" + result);
    }
}
