package com.xyh.game.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xyh.game.JavaWebToken;



public class MyInterceptor1 implements HandlerInterceptor {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
         request.getHeaderNames();
        System.out.println(request.getHeaderNames());
        String token = request.getHeader("Access-Token" );
        System.out.println(request.getHeader("Access-Token" ));
        if(JavaWebToken.parserJavaWebToken(token) != null){
            //表示token合法
            return true;
        }else{
/*        	StringBuffer url = request.getRequestURL();
        	String uri = request.getRequestURI();
        	StringBuffer addr = CfYamlUtil.replaceAll(url, uri, "");
        	System.out.println(url);
        	System.out.println(addr);
        	response.sendRedirect(addr.toString());*/
            //token不合法或者过期
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }


}
