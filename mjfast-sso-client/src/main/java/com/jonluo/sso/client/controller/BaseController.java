package com.jonluo.sso.client.controller;

import com.jonluo.sso.client.utils.CookieUtil;
import com.jonluo.sso.client.utils.EnvVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class BaseController {

    @Autowired
    EnvVariable envVariable;

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse httpServletResponse) {
        CookieUtil.clear(httpServletResponse, envVariable.getJwtTokenCookieName(),envVariable.getCookieParentDomain());
        return "redirect:/";
    }
}
