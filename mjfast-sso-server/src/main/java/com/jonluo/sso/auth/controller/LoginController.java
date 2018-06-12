package com.jonluo.sso.auth.controller;

import com.jonluo.sso.auth.utils.CookieUtil;
import com.jonluo.sso.auth.utils.EnvVariable;
import com.jonluo.sso.auth.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 为了简化，我们使用一个HashMap(凭证)作为用户数据库。
 */
@Controller
public class LoginController {

    @Autowired
    EnvVariable envVariable;

    @RequestMapping("/")
    public String home(){
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletResponse httpServletResponse, String username, String password, String redirect, Model model){
        /**
         * 简单用户认证map
         */
        Map<String, String> credentials = new HashMap<>();
        credentials.put("admin", "admin");

        if (username == null || !credentials.containsKey(username) || !credentials.get(username).equals(password)){
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }

        String token = JwtUtil.generateToken(envVariable.getSigningKey(), username);

        CookieUtil.create(httpServletResponse, envVariable.getJwtTokenCookieName(), token, false, -1, envVariable.getCookieParentDomain());

        return "redirect:" + redirect;
    }
}
