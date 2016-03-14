package com.operation.spi;

import com.operation.domain.YyApp;

import java.util.List;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-10,  下午2:46
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */
public interface IYyAppService {

    /**
     * 保存app信息
     *
     * @param app
     */
    void save(YyApp app);

    /**
     * 查询所有app
     *
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return
     */
    Map<String, Object> findAll(Integer pageSize, Integer pageIndex, String status, Boolean isDeleted, String keyword);

    /**
     * 查找所有未删除的app
     *
     * @return
     */
    List<YyApp> findAll();

    /**
     * 根据id查询app
     *
     * @param id
     * @return
     */
    YyApp findOne(String id);

    void delete(String appId);

    YyApp update(YyApp app);
}
