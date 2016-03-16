package com.operation.spi;

import com.operation.domain.YyAdminUser;
import com.operation.domain.YyAdminUserLog;

import java.util.List;
import java.util.Map;

/**
 * @author : Hui.Wang [huzi.wh@gmail.com]
 * @version : 1.0
 * @created on  : 2016-03-01,  上午11:07
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */
public interface IAdminUserService {

    /**
     * 添加管理员
     *
     * @param adminUser
     */
    YyAdminUser save(YyAdminUser adminUser);

    /**
     * id不能为空
     *
     * @param adminUser
     * @return
     */
    YyAdminUser update(YyAdminUser adminUser);

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
    Map<String, Object> findAll(Integer pageSize, Integer pageIndex, String keyword);

    /**
     * 登陆
     *
     * @return
     */
    YyAdminUser signin(String email, String password);

    void recordLog(YyAdminUserLog yyAdminUserLog);


    /**
     * 根据 email查询
     *
     * @param email
     * @return
     */
    YyAdminUser findByEmail(String email);

    /**
     * 修改登陆密码
     * @param email
     * @param password
     * @return
     */
    boolean updatePassword(String email, String password);
    boolean updatePasswordById(String id, String password);

    List<YyAdminUserLog> findSigninLogById(String adminUserId, Integer pageIndex, Integer pageSize);

    void delete(String adminUserId);

    YyAdminUser findById(String adminUserId);

    List<YyAdminUser> findAll();

}
