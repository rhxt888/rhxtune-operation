package com.operation.spi;

import com.operation.domain.YyContactInfo;

import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-02-29,  下午7:24
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */
public interface IContactInfoService {
    /**
     * 添加应用联系方式
     *
     * @param contactInfo
     */
    void save(YyContactInfo contactInfo);

    /**
     * 查询所有联系方式
     *
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return
     */
    Map<String, Object> findAll(Integer pageSize, Integer pageIndex, String keyword);

    /**
     * 查询某个app的联系方式
     *
     * @param appSlug
     * @return
     */
    YyContactInfo findOne(String appSlug);

}
