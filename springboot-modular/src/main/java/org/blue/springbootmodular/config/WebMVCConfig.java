package org.blue.springbootmodular.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author blue
 * @date 2021/8/12
 */
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("POST","GET","DELETE","PUT","OPTIONS")
                .allowCredentials(false);
    }
}
