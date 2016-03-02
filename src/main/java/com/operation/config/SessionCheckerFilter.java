package com.operation.config;



import com.operation.domain.YyAdminUser;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-01,  下午8:16
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */
public class SessionCheckerFilter implements Filter {

    @Resource
    private WebConfig webConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String servletPath = request.getServletPath();

        Pattern pattern = Pattern.compile("/v\\d+/(phoneCode/.*$)|(account/sign.*$)|(location/.*$)|(account/forget.*$)");
        if(pattern.matcher(servletPath).find()){
            filterChain.doFilter(request,response);
        } else {
            YyAdminUser sessionUser = (YyAdminUser)request.getSession().getAttribute(webConfig.getSessionName());
            System.out.println("current signin:"+ sessionUser.getEmail());
        }
    }

    @Override
    public void destroy() {

    }
}
