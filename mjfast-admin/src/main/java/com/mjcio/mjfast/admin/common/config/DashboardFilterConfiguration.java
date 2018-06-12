package com.mjcio.mjfast.admin.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mjcio.mjframe.system.dashboard.filter.MonitoringFilter;

@Configuration
public class DashboardFilterConfiguration {
	@Bean
    public FilterRegistrationBean DashboardRegistration() {
		
		FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MonitoringFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("filter-regex", "");//过滤的正则表达式，允许不配置，默认为空
        registration.addInitParameter("filter-suffix", "");//过滤的文件类型，允许不配置，默认为空
        registration.addInitParameter("dataPath", "/mjcioMonitor");//监控日志数据存在的路径，允许不配置，默认为/mjcioMonitor
        registration.addInitParameter("excludeType", "");//排序监控的类型，允许不配置，默认为空，则全部监控
        registration.addInitParameter("includeType", "cpu"); //包含监控的类型，允许不配置，默认为cpu 
        registration.addInitParameter("monitorInterval", "600");//监控的时间间隔，允许不配置，默认为60（毫秒）
        registration.addInitParameter("isOpenHttpRequest", "true");
        registration.setName("monitorFilter");
        registration.setOrder(1);
        return registration;
	}
}
