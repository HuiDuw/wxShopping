package com.huiduw.xshopping.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: 灰渡w
 * @Date: 2023/5/18 17:26
 * 全局拦截配置，随springboot启动就会加载
 */
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //实现WebMvcConfigurer不会导致静态资源被拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/end/page/**")
                .excludePathPatterns("/end/page/login.html");
    }
}
