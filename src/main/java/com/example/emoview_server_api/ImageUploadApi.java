package com.example.emoview_server_api;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;

public class ImageUploadApi {
    private static final String SECRET_KEY = "secretKey";

    //יוצרת טוקן לאותו משתמש למשך 24 שעות ומבטיחה לא יוכל להשתנות כי יש מפתח סודי שחותם אותו
    public static String createJWT(String username) {   //JWT = json web token
        long expirationTimeMillis = System.currentTimeMillis() + 86400000; // 24 שעות מעכשיו במילי שניות
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(expirationTimeMillis))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    //מאמת את הטוקן עם המפתח
    public static boolean validateJWT(String jwt) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //מחזירה את התמונה בצורה טקסטואלית (base64)
    public static String encodeImageToBase64(File imageFile) throws IOException {
        try (FileInputStream imageInputStream = new FileInputStream(imageFile)) {
            byte[] imageData = imageInputStream.readAllBytes();
            return Base64.getEncoder().encodeToString(imageData);
        }
    }

    //פונקציה ששולחת תמונה לשרת באמצעות API
    public static void sendImage(String jwt, String encodedImage) {
        // Perform an HTTPS POST request to the server with the JWT and the encodedImage data
        // Server-side, you should validate the JWT before accepting the image.
    }
}
