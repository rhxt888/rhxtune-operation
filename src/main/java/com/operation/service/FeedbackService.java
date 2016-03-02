package com.operation.service;

import com.operation.dao.YyFeedbackCateDao;
import com.operation.dao.YyFeedbackDao;
import com.operation.dao.YyFeedbackPreDao;
import com.operation.domain.YyFeedback;
import com.operation.domain.YyFeedbackCate;
import com.operation.domain.YyFeedbackPre;
import com.operation.spi.IFeedbackService;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-02,  下午7:36
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */
@Service
public class FeedbackService implements IFeedbackService{
    @Resource
    YyFeedbackDao yyFeedbackDao;
    @Resource
    YyFeedbackPreDao yyFeedbackPreDao;
    @Resource
    YyFeedbackCateDao yyFeedbackCateDao;
    /**
     * 添加修改分类
     *
     * @param feedbackCate
     */
    @Override
    public void saveCate(YyFeedbackCate feedbackCate) {
        yyFeedbackCateDao.save(feedbackCate);
    }

    /**
     * 添加修改预置反馈
     *
     * @param yyFeedbackPre
     */
    @Override
    public void savePre(YyFeedbackPre yyFeedbackPre) {
        yyFeedbackPreDao.save(yyFeedbackPre);
    }

    /**
     * 添加反馈
     *
     * @param yyFeedback
     */
    @Override
    public void save(YyFeedback yyFeedback) {
        yyFeedbackDao.save(yyFeedback);
    }

    /**
     * 查询所有反馈分类
     *
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return
     */
    @Override
    public Map<String,Object> findAllCate(Integer pageSize, Integer pageIndex, String keyword) {
        int limit = pageSize == null ? 10 : pageSize;
        int offset = (pageIndex - 1) * limit;
        Query query = yyFeedbackCateDao.createQuery().limit(limit).offset(offset);
        Map result = new HashMap();
        result.put("total", query.countAll());
        result.put("list", query.asList());
        return result;
    }

    /**
     * 查询所有预置反馈内容
     *
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return
     */
    @Override
    public Map<String,Object> findAllPre(Integer pageSize, Integer pageIndex, String keyword) {
        int limit = pageSize == null ? 10 : pageSize;
        int offset = (pageIndex - 1) * limit;
        Query query = yyFeedbackCateDao.createQuery().limit(limit).offset(offset);
        Map result = new HashMap();
        result.put("total", query.countAll());
        result.put("list", query.asList());
        return result;
    }

    /**
     * 根据appSlug查询分类
     *
     * @param appSlug
     * @return
     */
    @Override
    public List<YyFeedbackCate> findCateByAppSlug(String appSlug) {
        Query query = yyFeedbackCateDao.createQuery().filter("appSlug",appSlug);
        return query.asList();
    }

    /**
     * 根据appSlug查询 预置内容
     *
     * @param appSlug
     * @return
     */
    @Override
    public List<YyFeedbackPre> findPreByAppSlug(String appSlug) {
        Query query = yyFeedbackPreDao.createQuery().filter("appSlug",appSlug);
        return query.asList();
    }
}
