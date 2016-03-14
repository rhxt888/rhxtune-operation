package com.operation.service;

import com.operation.dao.YyBannerDao;
import com.operation.dao.YyPositionDao;
import com.operation.domain.YyArticle;
import com.operation.domain.YyBanner;
import com.operation.domain.YyPosition;
import com.operation.spi.IYyBannerService;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
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
     * @param banner
     */
    @Override
    public void save(YyBanner banner) {
        yyBannerDao.save(banner);
    }

    /**
     * 更新 banner
     *
     * @param banner
     */
    @Override
    public void update(YyBanner banner) {
        Query<YyBanner> query = yyBannerDao.createQuery().filter("_id", new ObjectId(banner.getId()));
        UpdateOperations updateOperations = yyBannerDao.createUpdateOperations()
                .set("position", banner.getPosition())
                .set("num", banner.getNum())
                .set("appInfo", banner.getAppInfo())
                .set("title", banner.getTitle())
                .set("masterImg", banner.getMasterImg())
                .set("url", banner.getUrl())
                .set("description", banner.getDescription())
                .set("adminUser", banner.getAdminUser())
                .set("community", banner.getCommunity())
                .set("articleId", banner.getArticleId())
                .set("endTime", banner.getEndTime())
                .set("startTime", banner.getStartTime())
                .set("status", banner.getStatus())
                .set("remark", banner.getRemark());

        yyBannerDao.update(query, updateOperations);
    }

    /**
     * 更新banner状态
     *
     * @param id
     * @param status
     */
    @Override
    public void updateStatus(String id, String status) {
        Query<YyBanner> query = yyBannerDao.createQuery().filter("_id", new ObjectId(id));
        UpdateOperations updateOperations = yyBannerDao.createUpdateOperations()
                .set("status", status);

        yyBannerDao.update(query, updateOperations);
    }

    /**
     * 删除banner
     *
     * @param id
     */
    @Override
    public void delete(String id) {
        Query<YyBanner> query = yyBannerDao.createQuery().filter("_id", new ObjectId(id));
        UpdateOperations updateOperations = yyBannerDao.createUpdateOperations()
                .set("isDeleted", false);

        yyBannerDao.update(query, updateOperations);
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

    @Override
    public void enablePosition(String id, boolean isEnable) {
        Query<YyPosition> query = yyPositionDao.createQuery().filter("_id", new ObjectId(id));
        UpdateOperations updateOperations = yyPositionDao.createUpdateOperations()
                .set("isEnable",isEnable) ;

        yyPositionDao.update(query, updateOperations);

        //将该位置下的所有banner下线
        Query<YyBanner> bannerQuery = yyBannerDao.createQuery().filter("position.id", new ObjectId(id));
        UpdateOperations bupdateOperations = yyBannerDao.createUpdateOperations()
                .set("status","offline") ;
        yyBannerDao.update(bannerQuery, bupdateOperations);




    }

    /**
     * 更新运营位
     *
     * @param position
     */
    @Override
    public void updatePosition(YyPosition position) {
        Query<YyPosition> query = yyPositionDao.createQuery().filter("_id", new ObjectId(position.getId()));
        UpdateOperations updateOperations = yyPositionDao.createUpdateOperations()
                .set("num", position.getNum())
                .set("name",position.getName())
                .set("description",position.getDescription())
                .set("isEnable",position.isEnable())
                .set("appInfo",position.getAppInfo());

        yyPositionDao.update(query, updateOperations);
    }

    /**
     * 删除运营位
     *
     * @param positionId
     */
    @Override
    public void deletePosition(String positionId) {
        Query<YyPosition> query = yyPositionDao.createQuery().filter("_id", new ObjectId(positionId));
        yyPositionDao.deleteByQuery(query);

        //将该位置下的所有banner下线
        Query<YyBanner> bannerQuery = yyBannerDao.createQuery().filter("position.id", new ObjectId(positionId));
        yyBannerDao.deleteByQuery(bannerQuery);
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

    @Override
    public List<YyPosition> findAllPosition() {
        Query query = yyPositionDao.createQuery();
        return query.asList();
    }

    /**
     * 根据position id查询 position 信息
     *
     * @param positionId
     * @return
     */
    @Override
    public YyPosition findPositionById(String positionId) {
        Query query = yyPositionDao.createQuery().filter("_id", new ObjectId(positionId));

        return yyPositionDao.findOne(query);
    }
}
