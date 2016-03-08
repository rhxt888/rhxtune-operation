package com.operation.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-03,  下午3:15
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */

@Entity(value = "yy_adminUserLog", noClassnameStored = true)
public class YyAdminUserLog {

    @Id
    private ObjectId id;

    @Embedded
    private YyAdminUser adminUser;
    private String sessionId;
    private String ip;
    private String agents;
    private String remark;
    private long signinTime = new Date().getTime();

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public YyAdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(YyAdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAgents() {
        return agents;
    }

    public void setAgents(String agents) {
        this.agents = agents;
    }

    public long getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(long signinTime) {
        this.signinTime = signinTime;
    }
}
