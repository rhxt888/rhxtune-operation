package com.operation.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-03,  下午7:02
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){

        return "feedback/index";
    }
}
