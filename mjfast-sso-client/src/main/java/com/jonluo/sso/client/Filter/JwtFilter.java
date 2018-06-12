package com.jonluo.sso.client.Filter;

import com.jonluo.sso.client.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JwtFilter强制执行单点登录。如果JWT令牌不存在(未经验证)，则重定向到认证。
 * 如果JWT令牌存在(已验证)，则提取用户标识并转发请求。
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    private  String jwtTokenCookieName;
    private  String signingKey;

    public JwtFilter(String jwtTokenCookieName, String signingKey) {
        this.jwtTokenCookieName = jwtTokenCookieName;
        this.signingKey = signingKey;
    }

    @Override
    public void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String username = JwtUtil.getSubject(httpServletRequest, this.jwtTokenCookieName, this.signingKey);
        if(username == null){
            String authService = this.getFilterConfig().getInitParameter("services.auth");
            httpServletResponse.sendRedirect(authService + "?redirect=" + httpServletRequest.getRequestURL());
        } else{
            httpServletRequest.setAttribute("username", username);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
