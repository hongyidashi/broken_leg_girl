package com.blg.framework.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
//    @Bean
//    public RequestContextListener requestContextListener(){
//        return new RequestContextListener();
//    }

    //---------------------跨域问题解决---------------------
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("*");
//    }
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        resolvers.add(new PageableHandlerMethodArgumentResolver());
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(source);
//    }
    //---------------------跨域问题解决---------------------

    //---------------------中文乱码解决---------------------
    @Bean
    public FastJsonHttpMessageConverter responseBodyConverter() {
        return new FastJsonHttpMessageConverter();
    }

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }

    static class FastJsonConfiguration extends WebMvcConfigurationSupport {
        /**
         * 修改自定义消息转换器
         * @param converters 消息转换器列表
         */
        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
            //调用父类的配置
            super.configureMessageConverters(converters);
            //创建fastJson消息转换器
            FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

            //升级最新版本需加=============================================================
            List<MediaType> supportedMediaTypes = new ArrayList<>();
            supportedMediaTypes.add(MediaType.APPLICATION_JSON);
            supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
            supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
            supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
            supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
            supportedMediaTypes.add(MediaType.APPLICATION_PDF);
            supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
            supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
            supportedMediaTypes.add(MediaType.APPLICATION_XML);
            supportedMediaTypes.add(MediaType.IMAGE_GIF);
            supportedMediaTypes.add(MediaType.IMAGE_JPEG);
            supportedMediaTypes.add(MediaType.IMAGE_PNG);
            supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
            supportedMediaTypes.add(MediaType.TEXT_HTML);
            supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
            supportedMediaTypes.add(MediaType.TEXT_PLAIN);
            supportedMediaTypes.add(MediaType.TEXT_XML);
            fastConverter.setSupportedMediaTypes(supportedMediaTypes);

            //创建配置类
            FastJsonConfig fastJsonConfig = new FastJsonConfig();
            //修改配置返回内容的过滤
            //WriteNullListAsEmpty  ：List字段如果为null,输出为[],而非null
            //WriteNullStringAsEmpty ： 字符类型字段如果为null,输出为"",而非null
            //DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
            //WriteNullBooleanAsFalse：Boolean字段如果为null,输出为false,而非null
            //WriteMapNullValue：是否输出值为null的字段,默认为false
            fastJsonConfig.setSerializerFeatures(
                    SerializerFeature.DisableCircularReferenceDetect,
                    SerializerFeature.WriteMapNullValue
            );
            fastConverter.setFastJsonConfig(fastJsonConfig);
            //将fastjson添加到视图消息转换器列表内
            converters.add(fastConverter);
        }
    }
    //---------------------中文乱码解决---------------------

}
