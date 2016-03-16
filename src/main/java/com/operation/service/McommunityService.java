package com.operation.service;

import com.operation.spi.IMcommunityService;
import com.rhxtune.base.model.mongo.MCommunity;
import com.rhxtune.base.provider.dao.mongo.CommunityDao;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : 齐娜 [qi.na@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-15,  下午3:56
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */
@Service
public class McommunityService implements IMcommunityService{
    @Resource
    private CommunityDao communityDao;

    @Override
    public List<MCommunity> findAll() {
        Query<MCommunity> query = communityDao.createQuery().disableValidation();
        MCommunity mCommunity = query.get();
        return query.asList();
    }

    /**
     * 根据小区的id查询小区信息
     * @param communityId
     * @return
     */
    @Override
    public MCommunity findById(String communityId) {
        return communityDao.createQuery().disableValidation().filter("_id",new ObjectId(communityId)).get();
    }
}
