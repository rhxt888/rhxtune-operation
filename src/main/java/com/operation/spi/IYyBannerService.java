package com.operation.spi;

import com.operation.domain.YyBanner;
import com.operation.domain.YyPosition;

import java.util.List;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-02-29,  下午7:27
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */
public interface IYyBannerService {
    /**
     * 添加修改banner
     * @param yyPosition
     * @param banner
     */
    void save(YyPosition yyPosition, YyBanner banner);

    /**
     * 查找所有banner
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return
     */
    Map<String, Object> findAll(Integer pageSize, Integer pageIndex, String keyword);

    /**
     * 根据appSlug查找可用的banner
     *
     * @param appSlug
     * @param positionNum
     * @return
     */
    List<Map<String, Object>> findEnableAll(String appSlug, String positionNum);

    /**
     * 添加位置
     * @param position
     */
    void savePosition(YyPosition position);

    /**
     *
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return
     */
    Map<String, Object> findAllPosition(Integer pageSize, Integer pageIndex, String keyword);

}
