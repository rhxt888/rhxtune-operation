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
     *
     * @param banner
     */
    void save(YyBanner banner);

    /**
     * 更新 banner
     *
     * @param banner
     */
    void update(YyBanner banner);

    /**
     * 更新banner状态
     *
     * @param id
     * @param status
     */
    void updateStatus(String id, String status);

    /**
     * 删除banner
     *
     * @param id
     */
    void delete(String id);

    /**
     * 查找所有banner
     *
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
     *
     * @param position
     */
    void savePosition(YyPosition position);

    void enablePosition(String id, boolean isEnable);

    /**
     * 更新运营位
     *
     * @param position
     */
    void updatePosition(YyPosition position);

    /**
     * 删除运营位
     *
     * @param positionId
     */
    void deletePosition(String positionId);

    /**
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return
     */
    Map<String, Object> findAllPosition(Integer pageSize, Integer pageIndex, String keyword);

    List<YyPosition> findAllPosition();

    /**
     * 根据position id查询 position 信息
     *
     * @param positionId
     * @return
     */
    YyPosition findPositionById(String positionId);

    /**
     * 根据 banner id查询 banner信息
     * @param id
     * @return
     */
    YyBanner findBannerById(String id);
}
