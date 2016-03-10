package com.operation.domain;

import com.rhxtune.base.model.mongo.MCommunity;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-02-25,  下午2:41
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */

@Entity(value = "yy_banner",noClassnameStored = true)
public class YyBanner {

    @Id
    private String id;

    @Reference
    private YyPosition position;
    private String num;
    private String appSlug;
    private String remark;
    private String title;
    private String masterImg;
    private String description;
    private String url;

    @Embedded
    private YyAdminUser adminUser;

    @Embedded
    private MCommunity community;

    @Reference
    private YyArticle article;
    private String status;  //draft,online,offline
    private long viewCount;
    private long startTime;
    private long endTime;
    private long createdTime = new Date().getTime();
    private boolean isDeleted;

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

    public YyPosition getPosition() {
        return position;
    }

    public void setPosition(YyPosition position) {
        this.position = position;
    }

    public String getAppSlug() {
        return appSlug;
    }

    public void setAppSlug(String appSlug) {
        this.appSlug = appSlug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMasterImg() {
        return masterImg;
    }

    public void setMasterImg(String masterImg) {
        this.masterImg = masterImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
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

    public MCommunity getCommunity() {
        return community;
    }

    public void setCommunity(MCommunity community) {
        this.community = community;
    }

    public YyArticle getArticle() {
        return article;
    }

    public void setArticle(YyArticle article) {
        this.article = article;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public YyAdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(YyAdminUser adminUser) {
        this.adminUser = adminUser;
    }
}
