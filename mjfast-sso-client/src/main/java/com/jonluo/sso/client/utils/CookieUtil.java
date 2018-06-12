package com.jonluo.sso.client.utils;

import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static void create(HttpServletResponse httpServletResponse, String name, String value, Boolean secure, Integer maxAge, String domain) {
        Cookie cookie = new Cookie(name, value);
        //secure=true : 只工作于HTTPS
        cookie.setSecure(secure);
        //对JavaScript不可见
        cookie.setHttpOnly(true);
        //maxAge=0：cookie现在过期,maxAge<0：在浏览器退出时过期。
        cookie.setMaxAge(maxAge);
        //仅在域可见
        cookie.setDomain(domain);
        //所有路径都可见
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
    }

    public static void clear(HttpServletResponse httpServletResponse, String name ,String domain) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        cookie.setDomain(domain);
        httpServletResponse.addCookie(cookie);
    }
    public static String getValue(HttpServletRequest httpServletRequest, String name) {
        Cookie cookie = WebUtils.getCookie(httpServletRequest, name);
        return cookie != null ? cookie.getValue() : null;
    }
}

