package com.example.interceptor;

import com.example.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@CrossOrigin
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin","http://localhost:63342");
        String token = request.getHeader("token");
        System.out.println("token = " + token);
        if (token==null||token.equals("")){
            response.sendError(response.SC_BAD_REQUEST);
            return false;
        }

        try {
            if(token!=null&&!token.equals("")){
                Claims claims = JwtUtil.parseJWT(token);
                System.out.println("claims.getSubject() = " + claims.getSubject());
            }
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(401,"身份验证未通过");
            return false;
        }
        return true;
    }
}
