package furryweb.example.Util;

import furryweb.example.Dao.UserRepository;
import io.jsonwebtoken.*;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.security.pkcs11.wrapper.Constants;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/11.
 */

@Component
public class JwtUtil {
    private static final int EXPSECOND= 60*60*5*1000;
    static final String TOKEN_PREFIX = "Bearer";
    private static Key getKeyInstance() {
        //We will sign our JavaWebToken with our ApiKey secret
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("bankgl");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
    }
    public static String createJavaWebToken(Map<String, Object> claims) {
        Long now = System.currentTimeMillis();
        Long expMills = now + EXPSECOND;
        System.out.println("到期时间:"+new Date(expMills));
        Date expDate = new Date(expMills);
        return Jwts.builder().setClaims(claims).setExpiration(expDate).signWith(SignatureAlgorithm.HS256, getKeyInstance()).compact();

    }
    public static int getUserIdByparserJavaWebToken(String jwt) {
        try {
            Map<String, Object> jwtClaims =
                    Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwt).getBody();
            return (Integer)jwtClaims.get("userId");
        } catch (Exception e) {
            return 0;
        }
    }


}