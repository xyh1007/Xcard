package com.xyh.game;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
/*import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;*/
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import com.xyh.game.interceptor.MyInterceptor1;


@SpringBootApplication
@ServletComponentScan
public class XcardApplication /*extends SpringBootServletInitializer */{
/*	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }*/
	public static void main(String[] args) {
		SpringApplication.run(XcardApplication.class, args);
	}
	@Configuration
	public class VdmDefaultViewConfig implements WebMvcConfigurer {
	    @Override
	    public void addViewControllers( ViewControllerRegistry registry ) {
			registry.addViewController( "/" ).setViewName( "redirect:/user" );
	        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
	        WebMvcConfigurer.super.addViewControllers( registry );
	    }
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        // 多个拦截器组成一个拦截器链
	        // addPathPatterns 用于添加拦截规则
	        // excludePathPatterns 用户排除拦截
	        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**").
	        excludePathPatterns("/login").excludePathPatterns("/register");
	      
	        //registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
	        WebMvcConfigurer.super.addInterceptors(registry);
	    }
	}
    
}
