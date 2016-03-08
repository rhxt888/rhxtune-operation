package com.operation.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;

/**
 * @author : 信义明 [xin.yiming@rhxtune.com]
 * @version : 1.0
 * @created on  : 2015-09-07,  下午2:19
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */
@Entity(value = "yy_feedbackPre",noClassnameStored = true)
public class YyFeedbackPre {

    @Id
    private ObjectId id;
    private String content;
    private String appSlug;
    @Reference
    private YyFeedbackCate cate;

    private long createdTime = new Date().getTime();

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAppSlug() {
        return appSlug;
    }

    public void setAppSlug(String appSlug) {
        this.appSlug = appSlug;
    }

    public YyFeedbackCate getCate() {
        return cate;
    }

    public void setCate(YyFeedbackCate cate) {
        this.cate = cate;
    }
}
