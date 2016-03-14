package com.operation.spi;

import com.operation.domain.YyAdminUser;
import com.operation.domain.YyArticle;

import java.util.List;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-02-29,  下午7:26
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */
public interface IYyArticleService {
    /**
     * 保存文章内容
     *
     * @param yyArticle
     */
    void save(YyArticle yyArticle);

    /**
     * 查询所有文章
     *
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return
     */
    Map<String, Object> findAll(Integer pageSize, Integer pageIndex, String status, Boolean isDeleted, String keyword);

    /**
     * 根据id查询文章
     *
     * @param id
     * @return
     */
    YyArticle findOne(String id,Boolean isReaded);

    void delete(String adminUserId);

    YyArticle  update(YyArticle article);

    List<YyArticle> findByTemplate(String template);

}
