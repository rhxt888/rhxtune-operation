package com.operation.web.utils;

import com.operation.config.WebConfiguration;
import com.operation.domain.YyAdminUser;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-03,  上午10:44
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */

@Component
public class SessionUtil {
    @Resource
    WebConfiguration webConfig;
    public  YyAdminUser getSessionUser() {
        YyAdminUser au = null;
        Object obj = RequestUtil.getRequest().getSession().getAttribute(webConfig.getSessionName());
        if (null != obj) {
            au = (YyAdminUser) obj;
        }
        return au;
    }

    public void  setSessionUser(String key,YyAdminUser yyAdminUser) {
        RequestUtil.getRequest().getSession().setAttribute(key,yyAdminUser);
    }

    public  String  getSessionId() {
        return RequestUtil.getRequest().getSession().getId();
    }



}
