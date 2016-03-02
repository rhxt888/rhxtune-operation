package com.operation.web.api;

import com.operation.spi.IContactInfoService;
import com.rhxtune.base.spi.account.IAccountService;
import com.rhxtune.common.model.ResultObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-02-25,  下午4:49
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */
@RestController
@RequestMapping("/api/v1/contract")
public class ContractInfoApiController {
    @Resource
    IContactInfoService contactInfoService;

    @RequestMapping("/{appSlug}")
    public ResultObject findOne(@PathVariable String appSlug){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(contactInfoService.findOne(appSlug));
        return resultObject;
    }

}
