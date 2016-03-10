package com.operation.web.action;

import com.operation.domain.YyBanner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-03,  下午3:41
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */
@Controller
@RequestMapping("/app")
public class AppController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index() {

        return "app/index";
    }

    @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
    public String add(HttpServletRequest request) {

        String redirect = "app/app-add";
        if (request.getMethod().equals(RequestMethod.POST.toString())){
            //add
            redirect = "redirect:/app";
        }

        return redirect;
    }

    @RequestMapping(value = "{id}/update", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(HttpServletRequest request, @PathVariable String id, @ModelAttribute YyBanner banner) {

        String redirect = "app/app-update";
        if (request.getMethod().equals(RequestMethod.POST.toString())){
            //add
            redirect = "redirect:/app";
        }

        return redirect;
    }

    @RequestMapping(value = "{appId}/del", method = RequestMethod.GET)
    public String del(@PathVariable String appId) {

        return "redirect:/app";
    }
}
