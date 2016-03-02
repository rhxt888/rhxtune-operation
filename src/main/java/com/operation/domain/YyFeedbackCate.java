package com.operation.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * @author : 信义明 [xin.yiming@rhxtune.com]
 * @version : 1.0
 * @created on  : 2015-09-07,  上午11:48
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */
@Entity(value = "yy_feedbackCate", noClassnameStored = true)
public class YyFeedbackCate {

    @Id
    private ObjectId id;

    private String name;

    private String appSlug;

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
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
}
