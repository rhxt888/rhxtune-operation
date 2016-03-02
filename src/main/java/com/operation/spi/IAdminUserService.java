package com.operation.spi;

import com.operation.domain.YyAdminUser;

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
    void save(YyAdminUser adminUser);

    /**
     * 查询所有管理员
     *
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return
     *
     * 返回结果如下:
     * <pre>
     *     {
     *         total: 12,
     *         list: []
     *     }
     * </pre>
     */
    Map<String,Object> findAll(Integer pageSize, Integer pageIndex, String keyword);

    /**
     * 登陆
     *
     * @param adminUser
     * @return
     */
    YyAdminUser signin(YyAdminUser adminUser);

    /**
     * 修改登陆密码
     *
     * @param email
     * @param password
     * @return
     */
    boolean updatePassword(String email, String password);

}
