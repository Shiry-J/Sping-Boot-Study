package com.example.utils;

import com.example.annotation.CurrentUserId;
import io.jsonwebtoken.Claims;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class UserIdArgumentResolver implements HandlerMethodArgumentResolver {


    // 指定方法参数前可以添加 CurrentUserId 注解
    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        return parameter.hasParameterAnnotation(CurrentUserId.class);

    }



    // 解析参数
    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        String token = webRequest.getHeader("token");
        if(StringUtils.hasText(token)){  // 非空

            //解析token，获取userId
            Claims claims = JwtUtil.parseJWT(token);
            String subject = claims.getSubject();
            return Integer.valueOf(subject);

        }
        return null;
    }


}
