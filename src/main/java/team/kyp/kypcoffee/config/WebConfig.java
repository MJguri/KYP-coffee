package team.kyp.kypcoffee.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final HandlerInterceptor loginVerification;

//    private List<String> notLoadList;

    //외부에 있는 상품이미지 저장폴더 경로 설정하기
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        // addResourceHandler : 스프링부트에서 확인할 폴더 위치 설정
        // addResourceLocations : 실제 시스템의 폴더 위치

        registry.addResourceHandler("/productImg/**").addResourceLocations("file:///C:/productImg/");
        registry.addResourceHandler("/reviewImg/**").addResourceLocations("file:///C:/reviewImg/");

        // 맥북 파일경로 설정
        //registry.addResourceHandler("/productImg/**").addResourceLocations("맥북파일경로");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginVerification).addPathPatterns("/mypage").excludePathPatterns("/login");

        /*
         * registry.addInterceptor(commonInterceptor) .addPathPatterns("/**") // 추가할 url
         * 패턴 .excludePathPatterns("/user/**"); // 제외할 url 패턴
         */
    }
}

