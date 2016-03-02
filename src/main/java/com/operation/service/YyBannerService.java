package com.operation.service;

import com.operation.dao.YyBannerDao;
import com.operation.dao.YyPositionDao;
import com.operation.domain.YyBanner;
import com.operation.domain.YyPosition;
import com.operation.spi.IYyBannerService;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-02,  下午7:38
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */
@Service
public class YyBannerService implements IYyBannerService {
    @Resource
    YyBannerDao yyBannerDao;

    @Resource
    YyPositionDao yyPositionDao;

    /**
     * 添加修改banner
     *
     * @param yyPosition
     * @param banner
     */
    @Override
    public void save(YyPosition yyPosition, YyBanner banner) {
        yyBannerDao.save(banner);
    }

    /**
     * 查找所有banner
     *
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return
     */
    @Override
    public Map<String, Object> findAll(Integer pageSize, Integer pageIndex, String keyword) {
        int limit = pageSize == null ? 10 : pageSize;
        int offset = (pageIndex - 1) * limit;
        Query query = yyBannerDao.createQuery().limit(limit).offset(offset);
        Map result = new HashMap();
        result.put("total", query.countAll());
        result.put("list", query.asList());
        return result;
    }

    /**
     * 根据appSlug查找可用的banner
     *
     * @param appSlug
     * @param positionNum
     * @return
     */
    @Override
    public List<Map<String, Object>> findEnableAll(String appSlug, String positionNum) {
        Query query = yyBannerDao.createQuery().filter("appSlug", appSlug).filter("positionNum", positionNum);
        return query.asList();
    }

    /**
     * 添加位置
     *
     * @param position
     */
    @Override
    public void savePosition(YyPosition position) {
        yyPositionDao.save(position);
    }

    /**
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return
     */
    @Override
    public Map<String, Object> findAllPosition(Integer pageSize, Integer pageIndex, String keyword) {
        int limit = pageSize == null ? 10 : pageSize;
        int offset = (pageIndex - 1) * limit;
        Query query = yyPositionDao.createQuery().limit(limit).offset(offset);
        Map result = new HashMap();
        result.put("total", query.countAll());
        result.put("list", query.asList());
        return result;
    }
}
