package com.operation.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-03,  下午3:40
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */

@Controller
@RequestMapping("/message")
public class MessageController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){

        return "message/index";
    }


    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public String send(){
        return "message/send";
    }


    @RequestMapping(value = "/tag",method = RequestMethod.GET)
    public String tagList(){
        return "message/tag";
    }


    @RequestMapping(value = "/token",method = RequestMethod.GET)
    public String tokenList(){
        return "message/token";
    }

}
