package com.operation.spi;

import com.rhxtune.base.model.mongo.MCommunity;

import java.util.List;

/**
 * @author : 齐娜 [qi.na@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-15,  下午3:56
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */
public interface IMcommunityService {

    List<MCommunity> findAll();

    MCommunity findById(String communityId);
}
