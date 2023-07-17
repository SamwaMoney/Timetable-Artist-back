package SamwaMoney.TimeTableArtist.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    // token이 expire되었으면 true를 리턴하는 함수
    public static boolean isExpired(String token, String secretKey) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
                .getBody().getExpiration().before(new Date());
    }

    // token에서 userName을 꺼내어 리턴하는 함수
    public static String getUserName(String token, String secretKey) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
                .getBody().get("userName", String.class);
    }

    public static String createToken (String userName, String key, long expireTimeMs) {
        Claims claims = Jwts.claims();  // 일종의 Map. 토큰 생성에 필요한 데이터를 담아두는 공간.
        claims.put("userName", userName);   // 회원명을 저장

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))  // 발행 시각
                .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs)) // 만료 시각
                .signWith(SignatureAlgorithm.HS256, key)    // HS256이라는 알고리즘과 주어진 key를 이용해 암호화
                .compact()
                ;

    }
}
