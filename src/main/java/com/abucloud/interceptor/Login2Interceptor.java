package com.abucloud.interceptor;

import com.abucloud.dto.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Description:
 * @Author party-abu
 * @Date 2022/5/10 21:32
 */
public class Login2Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler02");
        // 异常处理方式
        //    1.直接返回false
        // return false;
        //    2.可以抛异常，让异常处理器处理
        // throw new CustomException();
        //    3.可以使用HttpServletResponse、HttpServletRequest进行重定向或者转发
        // response.sendRedirect("http://www.baidu.com");
        // request.getRequestDispatcher("/submit.jsp").forward(request, response);
        //    4.可以HttpServletResponse直接向页面写数据
        response.setContentType("application/json;charset=utf8");
        PrintWriter writer = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        String userJson = objectMapper.writeValueAsString(user);
        writer.write(userJson);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion02");
    }
}
