package com.operation.service;

import com.operation.dao.YyContactInfoDao;
import com.operation.domain.YyContactInfo;
import com.operation.spi.IContactInfoService;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-02,  下午7:34
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */
@Service
public class ContactInfoService implements IContactInfoService{
    @Resource
    YyContactInfoDao yyContactInfoDao;
    /**
     * 添加应用联系方式
     *
     * @param contactInfo
     */
    @Override
    public void save(YyContactInfo contactInfo) {
        yyContactInfoDao.save(contactInfo);
    }

    /**
     * 查询所有联系方式
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

        Query query = yyContactInfoDao.createQuery().limit(limit).offset(offset);
        Map result = new HashMap();
        result.put("total", query.countAll());
        result.put("list", query.asList());

        return result;
    }

    /**
     * 查询某个app的联系方式
     *
     * @param appSlug
     * @return
     */
    @Override
    public YyContactInfo findOne(String appSlug) {
        Query query = yyContactInfoDao.createQuery().filter("appSlug",appSlug);
        YyContactInfo yyContactInfo = yyContactInfoDao.findOne(query);
        return yyContactInfo;
    }
}
