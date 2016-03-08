package com.operation.domain;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

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
    private String appSlug;
    private String description;
    private long createTime = new Date().getTime();

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

    public String getAppSlug() {
        return appSlug;
    }

    public void setAppSlug(String appSlug) {
        this.appSlug = appSlug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
