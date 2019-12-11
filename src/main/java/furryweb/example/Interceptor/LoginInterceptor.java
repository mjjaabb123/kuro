package furryweb.example.Interceptor;

import furryweb.example.Util.JwtUtil;
import org.springframework.lang.Nullable;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

/**
 * Created by Administrator on 2019/10/10.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String accessToken = request.getHeader("accesstoken");
        String refreshToken = request.getHeader("refreshtoken");
        System.out.println("accesstoken:"+accessToken);
        System.out.println("refreshtoken:"+refreshToken);

        if (JwtUtil.getUserIdByparserJavaWebToken(accessToken) != -1) {
            //表示token合法
            return true;
        } else if (JwtUtil.getUserIdByparserJavaWebToken(refreshToken)!=-1) {
            Map<String, Object> jwtClaims = new HashMap();
            jwtClaims.put("userId",JwtUtil.getUserIdByparserJavaWebToken(refreshToken));
            response.setHeader("accesstoken",JwtUtil.createAccessJavaWebToken(jwtClaims));
            response.setHeader("refreshtoken",JwtUtil.createRefreshJavaWebToken(jwtClaims));
            return true;
        } else {
            System.out.println(request.getRequestURI());
            response.setStatus(SC_UNAUTHORIZED);
            //token不合法或者过期
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }

}