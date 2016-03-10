package com.operation.service;

import com.operation.dao.YyArticleDao;
import com.operation.domain.YyAdminUser;
import com.operation.domain.YyArticle;
import com.operation.spi.IYyArticleService;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-02,  下午7:36
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */
@Service
public class YyArticleService implements IYyArticleService {
    @Resource
    YyArticleDao yyArticleDao;

    /**
     * 保存文章内容
     *
     * @param yyArticle
     */
    @Override
    public void save(YyArticle yyArticle) {
        yyArticleDao.save(yyArticle);
    }

    /**
     * 查询所有文章
     *
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return
     */
    @Override
    public Map<String, Object> findAll(Integer pageSize, Integer pageIndex, String status, Boolean isDeleted, String keyword) {
        int limit = pageSize == null ? 10 : pageSize;
        int offset = (pageIndex - 1) * limit;
        Query query = yyArticleDao.createQuery().limit(limit).offset(offset).filter("status", status).filter("isDeleted", isDeleted);
        Map result = new HashMap();
        result.put("total", query.countAll());
        result.put("list", query.asList());
        return result;
    }

    /**
     * 根据id查询文章
     *
     * @param id
     * @param isReaded
     * @return
     */
    @Override
    public YyArticle findOne(String id, Boolean isReaded) {
        Query query = yyArticleDao.createQuery().filter("_id", new ObjectId(id));

        //记录月读数
        if (isReaded) {
            yyArticleDao.update(query, yyArticleDao.createUpdateOperations().inc("viewCount", +1));
        }

        return yyArticleDao.findOne(query);
    }

    @Override
    public void delete(String articleId) {
        Query query = yyArticleDao.createQuery().filter("_id", new ObjectId(articleId));
        UpdateResults updateResults = yyArticleDao.update(query, yyArticleDao.createUpdateOperations().set("isDeleted", true));
    }

    @Override
    public YyArticle update(YyArticle article) {
        Query<YyArticle> query = yyArticleDao.createQuery().filter("_id", new ObjectId(article.getId()));
        UpdateOperations updateOperations = yyArticleDao.createUpdateOperations()
                .set("status", article.getStatus())
                .set("template", article.getTemplate())
                .set("title", article.getTitle())
                .set("content", article.getContent());
        yyArticleDao.update(query, updateOperations);

        return article;
    }
}
