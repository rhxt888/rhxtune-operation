package com.operation.spi;

import com.operation.domain.YyFeedback;
import com.operation.domain.YyFeedbackCate;
import com.operation.domain.YyFeedbackPre;

import java.util.List;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-02-29,  下午7:25
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */
public interface IFeedbackService {
    /**
     * 添加修改分类
     *
     * @param feedbackCate
     */
    void saveCate(YyFeedbackCate feedbackCate);

    /**
     * 添加修改预置反馈
     *
     * @param yyFeedbackPre
     */
    void savePre(YyFeedbackPre yyFeedbackPre);

    /**
     * 添加反馈
     *
     * @param yyFeedback
     */
    void save(YyFeedback yyFeedback);

    /**
     * 查询所有反馈分类
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return
     */
    Map<String,Object> findAllCate(Integer pageSize, Integer pageIndex, String keyword);

    /**
     * 查询所有反馈分类
     * @return
     */
    List<YyFeedbackCate>findAllCate();

    /**
     * 查询所有预置反馈内容
     * @param pageSize
     * @param pageIndex
     * @param keyword
     * @return
     */
    Map<String,Object> findAllPre(Integer pageSize, Integer pageIndex, String keyword);

    /**
     * 根据appSlug查询分类
     * @param appSlug
     * @return
     */
    List<YyFeedbackCate> findCateByAppSlug(String appSlug);

    /**
     * 根据appSlug查询 预置内容
     * @param appSlug
     * @return
     */
    List<YyFeedbackPre> findPreByAppSlug(String appSlug);

    /**
     * 根据name查询
     * @param name
     * @return
     */
    List<YyFeedbackCate> findCateByName(String name);

    /**
     * 根据name查询
     * @param name
     * @return
     */
    List<YyFeedbackCate>findCateByNameAndAppSlug(String name,String appSlug);
}
