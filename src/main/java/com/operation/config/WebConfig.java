package com.operation.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-01,  下午8:05
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */
@Configuration
public class WebConfig {
    @Value("{app.session.name}")
    private String sessionName;

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }
}
