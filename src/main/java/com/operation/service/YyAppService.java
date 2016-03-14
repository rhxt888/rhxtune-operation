package com.operation.service;

import com.operation.dao.YyAppDao;
import com.operation.domain.YyApp;
import com.operation.spi.IYyAppService;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-10,  下午5:05
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */
@Service
public class YyAppService implements IYyAppService{
    @Resource
    YyAppDao yyAppDao;
    /**
     * 保存app信息
     *
     * @param app
     */
    @Override
    public void save(YyApp app) {
        yyAppDao.save(app);
    }

    /**
     * 查询所有app
     *
     * @param pageSize
     * @param pageIndex
     * @param status
     * @param isDeleted
     * @param keyword   @return
     */
    @Override
    public Map<String, Object> findAll(Integer pageSize, Integer pageIndex, String status, Boolean isDeleted, String keyword) {
        int limit = pageSize == null ? 10 : pageSize;
        int offset = (pageIndex - 1) * limit;
        Query query = yyAppDao.createQuery().limit(limit).offset(offset).filter("status", status).filter("isDeleted", isDeleted);
        Map result = new HashMap();
        result.put("total", query.countAll());
        result.put("list", query.asList());
        return result;
    }

    /**
     * 查找所有未删除的app
     *
     * @return
     */
    @Override
    public List<YyApp> findAll() {
        Query query = yyAppDao.createQuery().filter("isDeleted", false);
        return query.asList();
    }

    /**
     * 根据id查询app
     *
     * @param id
     * @return
     */
    @Override
    public YyApp findOne(String id) {
        Query query = yyAppDao.createQuery().filter("_id", new ObjectId(id));

        return yyAppDao.findOne(query);
    }

    @Override
    public void delete(String appId) {

        Query query = yyAppDao.createQuery().filter("_id", new ObjectId(appId));
        UpdateResults updateResults = yyAppDao.update(query, yyAppDao.createUpdateOperations().set("isDeleted", true));
    }

    @Override
    public YyApp update(YyApp app) {
        Query<YyApp> query = yyAppDao.createQuery().filter("_id", new ObjectId(app.getId()));
        UpdateOperations updateOperations = yyAppDao.createUpdateOperations()
                .set("status", app.getStatus())
                .set("name", app.getName())
                .set("version", app.getVersion())
                .set("adminUser", app.getAdminUser())
                .set("agreementUrl", app.getAgreementUrl())
                .set("description", app.getDescription())
                .set("contactInfo", app.getContactInfo())
                .set("slug", app.getSlug());

        yyAppDao.update(query, updateOperations);

        return app;
    }
}
