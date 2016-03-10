package com.operation.domain;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-02-25,  下午2:47
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */

@Entity(value = "yy_article",noClassnameStored = true)
public class YyArticle {

    @Id
    private String id;
    private String title;
    private String content;

    @Embedded
    private YyAdminUser adminUser;

    private String status;  //draft,online,offline

    private long viewCount;

    private long createdTime = new Date().getTime();

    private boolean isDeleted = false;

    private String template;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public YyAdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(YyAdminUser adminUser) {
        this.adminUser = adminUser;
    }
}
