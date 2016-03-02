package com.operation.web.api;

import com.operation.spi.IFeedbackService;
import com.rhxtune.common.model.ResultObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-02-25,  下午4:48
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */
@RestController
@RequestMapping("/api/v1/feedback")
public class FeedbackApiController {
    //获取反馈分类
    @Resource
    IFeedbackService feedbackService;


    //提交反馈
    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResultObject add(@PathVariable String appSlug){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(feedbackService.findPreByAppSlug(appSlug));
        return resultObject;
    }

    @RequestMapping("/cate/{appSlug}")
    public ResultObject findAllCate(@PathVariable String appSlug){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(feedbackService.findCateByAppSlug(appSlug));
        return resultObject;
    }

    //获取提前添加好的反馈

    @RequestMapping("/pre/{appSlug}")
    public ResultObject findAllPre(@PathVariable String appSlug){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(feedbackService.findPreByAppSlug(appSlug));
        return resultObject;
    }

}
