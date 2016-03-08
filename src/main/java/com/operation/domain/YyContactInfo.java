package com.operation.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author : 信义明 [xin.yiming@rhxtune.com]
 * @version : 1.0
 * @created on  : 2015-09-07,  上午11:41
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */
@Entity(value = "yy_contactInfo",noClassnameStored = true)
public class YyContactInfo {

    @Id
    private ObjectId id;

    private String appSlug;

    private long createdTime = new Date().getTime();

    @Property(concreteClass = java.util.TreeSet.class)
    private Set<String> tags;
    /**
     *
     {
       tel: 12312312,
       email: kkk@sdfs.com;
       qq: ksdfsdf;
       qqGroup:
       address:
     }
     */
    @Embedded(concreteClass = java.util.TreeMap.class)
    private Map<String,Object> info;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {

        this.info = info;
    }

    public String getAppSlug() {
        return appSlug;
    }

    public void setAppSlug(String appSlug) {
        this.appSlug = appSlug;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }
}
