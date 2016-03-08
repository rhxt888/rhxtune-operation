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

@Entity(value = "yy_message_log", noClassnameStored = true)
public class YyMessagePushLog {
    @Id
    private String id;

    @Embedded
    private YyMessage message;
}
