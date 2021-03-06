package com.operation.domain;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-02,  下午4:53
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */

@Entity(value = "yy_app", noClassnameStored = true)
public class YyApp {

    @Id
    private String id;
    private String name;

    private String slug;

    private String status = "dev";  //dev,prod,del

    private String description;

    private String version = "v1.0";

    @Embedded
    private YyAdminUser adminUser;

    //应用联系方式
    @Embedded(concreteClass = java.util.TreeMap.class)
    private Map<String, Object> contactInfo;

    private String articleId;

    //用户协议URL
    private String agreementUrl;


    private boolean isDeleted = false;

    private long createdTime = new Date().getTime();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public YyAdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(YyAdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public Map<String, Object> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Map<String, Object> contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAgreementUrl() {
        return agreementUrl;
    }

    public void setAgreementUrl(String agreementUrl) {
        this.agreementUrl = agreementUrl;
    }


    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {

        isDeleted = deleted;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {

        this.version = version;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
}
