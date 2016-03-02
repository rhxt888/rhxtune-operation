package com.operation.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 * @author : 信义明 [xin.yiming@rhxtune.com]
 * @version : 1.0
 * @created on  : 2015-09-07,  上午11:54
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */
@Entity(value = "yy_feedback",noClassnameStored = true)
public class YyFeedback {

    @Id
    private ObjectId id;
    private String appSlug;

    private String clientEnv;

    private String content;
    private String contact;

    private String contactType;

    @Reference
    private YyFeedbackCate cate;

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getClientEnv() {
        return clientEnv;
    }

    public void setClientEnv(String clientEnv) {
        this.clientEnv = clientEnv;
    }

    public String getAppSlug() {
        return appSlug;
    }

    public void setAppSlug(String appSlug) {
        this.appSlug = appSlug;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public YyFeedbackCate getCate() {
        return cate;
    }

    public void setCate(YyFeedbackCate cate) {
        this.cate = cate;
    }
}
