package com.operation.domain;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-02-25,  下午2:12
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */

@Entity(value = "yy_position",noClassnameStored = true)
public class YyPosition {

    @Id
    private String id;

    private String num;

    private String name;

    private String description;

    private boolean isEnable;


    @Embedded
    private YyApp appInfo;

    private long createdTime = new Date().getTime();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public YyApp getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(YyApp appInfo) {
        this.appInfo = appInfo;
    }
}
