package com.operation.domain;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

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
    private long createTime;
}
