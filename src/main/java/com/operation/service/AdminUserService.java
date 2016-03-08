package com.operation.service;

import com.operation.dao.YyAdminUserDao;
import com.operation.dao.YyAdminUserLogDao;
import com.operation.domain.YyAdminUser;
import com.operation.domain.YyAdminUserLog;
import com.operation.spi.IAdminUserService;
import com.rhxtune.common.utils.StringUtil;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-02,  上午10:21
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */

@Service
public class AdminUserService implements IAdminUserService {
    @Resource
    YyAdminUserDao yyAdminUserDao;

    @Resource
    YyAdminUserLogDao yyAdminUserLogDao;

    /**
     * 添加管理员
     *
     * @param adminUser
     */
    @Override
    public YyAdminUser save(YyAdminUser adminUser) {
        adminUser.setCreateTime(new Date().getTime());
        adminUser.setPassword(StringUtil.toPassword(adminUser.getPassword()));
        Key<YyAdminUser> kyu = yyAdminUserDao.save(adminUser);
        return adminUser;
    }

    /**
     * id不能为空
     *
     * @param adminUser
     * @return
     */
    @Override
    public YyAdminUser update(YyAdminUser adminUser) {
        Query<YyAdminUser> query = yyAdminUserDao.createQuery().filter("_id", adminUser.getId());
        UpdateOperations updateOperations = yyAdminUserDao.createUpdateOperations()
                .set("email", adminUser.getEmail())
                .set("role", adminUser.getRole())
                .set("screenName", adminUser.getScreenName());
        yyAdminUserDao.update(query, updateOperations);

        return adminUser;
    }


    /**
     * 查询所有管理员
     *
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return 返回结果如下:
     * <pre>
     *     {
     *         total: 12,
     *         list: []
     *     }
     * </pre>
     */
    @Override
    public Map<String, Object> findAll(Integer pageSize, Integer pageIndex, String keyword) {
        //query
        int limit = pageSize == null ? 10 : pageSize;
        int offset = (pageIndex - 1) * limit;
        Query<YyAdminUser> query = yyAdminUserDao.createQuery().disableValidation();
        query.or(
                query.criteria("isDeleted").doesNotExist(),
                query.criteria("isDeleted").equal(Boolean.FALSE)
        );

        query.limit(limit).offset(offset);
        Map result = new HashMap();
        result.put("total", query.countAll());
        result.put("list", query.asList());
        return result;
    }

    /**
     * 登陆
     *
     * @return
     */
    @Override
    public YyAdminUser signin(String email, String password) {
        Query query = yyAdminUserDao.createQuery()
                .filter("email", email)
                .filter("password", StringUtil.toPassword(password));
        YyAdminUser yyAdminUser = yyAdminUserDao.findOne(query);
        //更新最后登陆时间

        return yyAdminUser;
    }

    @Override
    public void recordLog(YyAdminUserLog yyAdminUserLog) {
        yyAdminUserLog.setSigninTime(new Date().getTime());
        Query query = yyAdminUserDao.createQuery()
                .filter("_id", yyAdminUserLog.getAdminUser().getId());
        yyAdminUserDao.update(query, yyAdminUserDao.createUpdateOperations()
                .set("lastSigninTime", new Date().getTime())
                .set("lastAgents", yyAdminUserLog.getAgents())
                .inc("signinCount", +1)
                .set("lastSigninIp", yyAdminUserLog.getIp()));

        yyAdminUserLogDao.save(yyAdminUserLog);
    }

    /**
     * 根据 email查询
     *
     * @param email
     * @return
     */
    @Override
    public YyAdminUser findByEmail(String email) {
        Query query = yyAdminUserDao.createQuery()
                .filter("email", email).filter("isDeleted",false);
        return yyAdminUserDao.findOne(query);
    }

    /**
     * 修改登陆密码
     *
     * @param email
     * @param password
     * @return
     */
    @Override
    public boolean updatePassword(String email, String password) {
        Query query = yyAdminUserDao.createQuery().filter("email", email);
        UpdateResults updateResults = yyAdminUserDao.update(query, yyAdminUserDao.createUpdateOperations().set("password", StringUtil.toPassword(password)));
        return updateResults.getUpdatedCount() > 0;
    }

    @Override
    public boolean updatePasswordById(String id, String password) {

        Query query = yyAdminUserDao.createQuery().filter("_id", new ObjectId(id));
        UpdateResults updateResults = yyAdminUserDao.update(query, yyAdminUserDao.createUpdateOperations().set("password", StringUtil.toPassword(password)));
        return updateResults.getUpdatedCount() > 0;
    }

    @Override
    public List<YyAdminUserLog> findSigninLogById(String adminUserId, Integer pageIndex, Integer pageSize) {
        Query query = yyAdminUserLogDao.createQuery().filter("adminUser._id", new ObjectId(adminUserId)).order("-signinTime");
        int limit = pageSize == null ? 10 : pageSize;
        int offset = (pageIndex - 1) * limit;
        query.limit(limit).offset(offset);

        return yyAdminUserLogDao.find(query).asList();
    }

    @Override
    public void delete(String adminUserId) {
        Query query = yyAdminUserDao.createQuery().filter("_id", new ObjectId(adminUserId));
        UpdateResults updateResults = yyAdminUserDao.update(query, yyAdminUserDao.createUpdateOperations().set("isDeleted", true));
    }

    @Override
    public YyAdminUser findById(String adminUserId) {
        Query query = yyAdminUserDao.createQuery().filter("_id", new ObjectId(adminUserId));
        return yyAdminUserDao.findOne(query);
    }
}
