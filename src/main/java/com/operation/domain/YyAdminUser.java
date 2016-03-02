package com.operation.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-02-29,  下午7:29
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */

@Entity(value = "yy_adminUser",noClassnameStored = true)
public class YyAdminUser {

    @Id
    private ObjectId id;
    private String email;
    private String password;
    private Integer userType;
    private String screenName;
    private String avatar;
    private Long createTime;
    private Long lastSigninTime;
    private String lastSigninIp;
    private String lastAgents;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {

        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {

        this.createTime = createTime;
    }

    public Long getLastSigninTime() {
        return lastSigninTime;
    }

    public void setLastSigninTime(Long lastSigninTime) {
        this.lastSigninTime = lastSigninTime;
    }

    public String getLastSigninIp() {
        return lastSigninIp;
    }

    public void setLastSigninIp(String lastSigninIp) {
        this.lastSigninIp = lastSigninIp;
    }

    public String getLastAgents() {
        return lastAgents;
    }

    public void setLastAgents(String lastAgents) {
        this.lastAgents = lastAgents;
    }
}
