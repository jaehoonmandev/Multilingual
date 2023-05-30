package com.multilingual.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class PropertiesConfig implements WebMvcConfigurer {

    /*messages properties 로 생성된 언어set 읽어오기*/
    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        /* src/main/resources/language/ 의 경로에서 messages 가 붙은 message Source를 모두 읽는다. */
        messageSource.setBasename("language/messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }
    /*세션과 쿠키와 같은 웹 기반 저장소에 Locale 정보를 저장해주는 LocaleResolver*/
    @Bean
    public LocaleResolver localeResolver(){
        /*LocaleResolver 인터페이스를 구현하여 HttpSessoin에 Locale을 지정.*/
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.KOREA);

        return slr;
    }

    /*Locale 변경되었을 때 Bean에 등록해주는 interceptor*/
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("language");
        return lci;
    }

    /*인테셉터를 WebMvcConfigure 인터페이스의 기능을 override 하여
    Spring interceptor 추가 */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(localeChangeInterceptor());
    }



}
