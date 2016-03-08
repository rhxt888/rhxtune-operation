package com.operation.domain;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-03,  下午7:25
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */

@Entity(value = "yy_message",noClassnameStored = true)
public class YyMessage {
    @Id
    private String id;
    //消息类型: 1:H5, 2:文本
    private String type;
    private String title;
    private String content;
    private String url;
    //消息列表主图
    private String img;

    @Embedded
    private YyArticle article;

    //推送范围
    private Map<String, Object> scope;

    private long createdTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public YyArticle getArticle() {
        return article;
    }

    public void setArticle(YyArticle article) {
        this.article = article;
    }
}
