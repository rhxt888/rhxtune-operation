package com.operation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.Filter;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-01,  下午8:05
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */
@Component("webConfig")
@Configuration
public class WebConfiguration implements EnvironmentAware{

    private static Logger log = LoggerFactory.getLogger(WebConfiguration.class);

    private RelaxedPropertyResolver propertyResolver;


    public String getSessionName() {
        return propertyResolver.getProperty("session.name");
    }

    public String getAdminEmail() {
        return propertyResolver.getProperty("admin.email");
    }


    public String getAmdinPassword() {
        return propertyResolver.getProperty("admin.password");
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment,"app.");
    }

    @Bean
    public Filter sessionCheckerFilter(){
        SessionCheckerFilter sessionCheckerFilter = new SessionCheckerFilter();
        return sessionCheckerFilter;
    }

    @Bean
    @ConditionalOnMissingBean(RequestContextListener.class)
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

}
