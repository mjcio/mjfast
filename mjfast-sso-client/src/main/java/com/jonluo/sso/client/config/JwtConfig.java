package com.jonluo.sso.client.config;

import com.jonluo.sso.client.Filter.JwtFilter;
import com.jonluo.sso.client.utils.EnvVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * Created by jonluo on 2017/9/27.
 */
@Configuration
public class JwtConfig {

    @Autowired
    EnvVariable envVariable;

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter(envVariable.getJwtTokenCookieName(),envVariable.getSigningKey()));
        registrationBean.setInitParameters(Collections.singletonMap("services.auth", envVariable.getAuthService()));
        //拦截所有
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
