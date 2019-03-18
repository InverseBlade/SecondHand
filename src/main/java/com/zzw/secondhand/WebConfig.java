package com.zzw.secondhand;

import com.zzw.secondhand.interceptor.GoodsDetailInterceptor;
import com.zzw.secondhand.interceptor.GoodsSubmitInterceptor;
import com.zzw.secondhand.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    UserInterceptor userInterceptor;

    @Resource
    GoodsDetailInterceptor goodsDetailInterceptor;

    @Resource
    GoodsSubmitInterceptor goodsSubmitInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/index")
                .excludePathPatterns("/index/**");

        registry.addInterceptor(goodsDetailInterceptor)
                .addPathPatterns("/goods/detail/*");

        registry.addInterceptor(goodsSubmitInterceptor)
                .addPathPatterns("/goods/save")
                .addPathPatterns("/goods/status")
                .addPathPatterns("/goods/buy");
    }
}
