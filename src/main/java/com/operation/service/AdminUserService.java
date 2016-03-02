package com.operation.service;

import com.operation.dao.YyAdminUserDao;
import com.operation.domain.YyAdminUser;
import com.operation.spi.IAdminUserService;
import com.rhxtune.common.utils.StringUtil;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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

    /**
     * 添加管理员
     *
     * @param adminUser
     */
    @Override
    public void save(YyAdminUser adminUser) {
        yyAdminUserDao.save(adminUser);
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
        Query query = yyAdminUserDao.createQuery().limit(limit).offset(offset);
        Map result = new HashMap();
        result.put("total", query.countAll());
        result.put("list", query.asList());
        return result;
    }

    /**
     * 登陆
     *
     * @param adminUser
     * @return
     */
    @Override
    public YyAdminUser signin(YyAdminUser adminUser) {
        Query query = yyAdminUserDao.createQuery()
                .filter("email", adminUser.getEmail())
                .filter("password", StringUtil.toPassword(adminUser.getPassword()));
        YyAdminUser yyAdminUser = yyAdminUserDao.findOne(query);

        return yyAdminUser;
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
}
