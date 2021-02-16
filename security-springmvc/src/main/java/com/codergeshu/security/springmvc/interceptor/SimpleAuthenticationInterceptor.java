package com.codergeshu.security.springmvc.interceptor;

import com.codergeshu.security.springmvc.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义拦截器
 *
 * @Date: 2021/1/27 21:20
 * @author: Eric
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {

    /**
     * 拦截请求
     * 1.当请求时会话中没有用户信息，则提示用户先登录系统；
     * 2.当存在用户信息，但当前用户没有访问相应资源权限时，提示相应信息；
     * 3.否则放行，允许用户访问资源
     *
     * @param request  用户请求
     * @param response 系统响应
     * @param handler  处理对象
     * @return 是否拦截，true：放行；false：拦截
     * @throws Exception IO异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute(User.SESSION_USER_KEY);
        if (obj == null) {
            writeMessage(request, response, "请先登录");
        }
        User user = (User) obj;
        // 获取请求的资源URL
        String requestURI = request.getRequestURI();
        if (requestURI.contains("r1") && user.getAuthorities().contains("p1")) {
            return true;
        }
        if (requestURI.contains("r2") && user.getAuthorities().contains("p2")) {
            return true;
        }
        writeMessage(request, response, user.getUsername() + " 没有权限访问当前资源");
        return false;
    }

    // 输出响应信息
    private void writeMessage(HttpServletRequest request, HttpServletResponse response, String msg) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.close();
        response.resetBuffer();
    }
}
