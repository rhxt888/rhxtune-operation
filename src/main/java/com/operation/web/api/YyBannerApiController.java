package com.operation.web.api;

import com.operation.spi.IYyBannerService;
import com.rhxtune.common.model.ResultObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-02-25,  下午4:46
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */

@RestController
@RequestMapping("/api/v1/banner")
public class YyBannerApiController {
    @Resource
    IYyBannerService yyBannerSertice;

    @RequestMapping("/{appSlug}")
    public ResultObject findAll(@PathVariable String appSlug, @RequestParam("positionNum") String positionNum) {
        ResultObject resultObject = new ResultObject();
        resultObject.setData(yyBannerSertice.findEnableAll(appSlug, positionNum));
        return resultObject;
    }
}
