package com.xyh.game;



import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
/*import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;*/
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import com.xyh.game.interceptor.MyInterceptor1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;


@SpringBootApplication
@ServletComponentScan
@MapperScan("com.xyh.game.mybatisplus.dao")
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

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}


}
