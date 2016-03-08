/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.operation.web.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Request util
 *
 * @created on  : 2015-07-02,  13:42:45
 * @author       : Hui.Wang [huzi.wh@gmail.com]
 * @version    : 1.0
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 *
 */
public class RequestUtil {

    /**
     * 取request
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 判断一个请求是不是ajax请求
     *
     * @return Boolean
     */
    public Boolean isAjaxRequest() {
        String xr = RequestUtil.getRequest().getHeader("x-requested-with");
        Boolean result = false;
        if (xr != null && !"".equals(xr) && xr.equals("XMLHttpRequest")) {
            result = true;
        }
        return result;
    }

    /**
     * 获取用户浏览器信息
     *
     * @return String
     */
    public static String getUserAgent() {
        String result = "";
        result = getRequest().getHeader("User-Agent");
        return result;
    }

    /**
     * 获取客户端ip
     *
     * @return String ip
     */
    public static String getClientIP() {
        String ip = "";
        HttpServletRequest request = RequestUtil.getRequest();
        ip = request.getHeader("X-Real-IP");
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取主机名
     *
     * @param request
     * @return String domain
     */
    public static String getDomain() {
        String domain = "";
        domain = getRequest().getHeader("Host");
		//lezhai365.com
        //www.zhuyiqi.com
        //lezhai365.cn
        //lezhai365.com.cn
        if (!"".equals(domain)) {
            String[] _domain = domain.split("\\.");
            //int firstDot = domain.indexOf(".") + 1;
            int len = _domain.length;
            if (len > 3) {
                domain = "lezhai365.com.cn";
            } else {
                domain = _domain[len - 2] + "." + _domain[len - 1];
            }
            //	System.out.println(domain);
        }
        return domain;
    }

    /**
     * 判断一个字符串,是不是ip字符串
     *
     * @param ipStr String
     * @return boolean
     */
    public static boolean isIpString(String ipStr) {
        String regex = "(((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(ipStr);
        return m.matches();
    }

    /**
     * 判断一个请求是不是pjax请求
     *
     * @return boolean
     */
    public boolean isPjaxRequest() {
        boolean result = false;
        String xr = getRequest().getHeader("X-PJAX");

        //TODO 这种判断方式还需要测试
        if (xr != null && !"".equals(xr) && xr.equals("true")) {
            result = true;
        }
        return result;
    }
}
