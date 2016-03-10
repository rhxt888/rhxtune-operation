package com.operation.web.action;

import com.operation.domain.YyAdminUser;
import com.operation.domain.YyBanner;
import com.operation.domain.YyPosition;
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
@RequestMapping("/banner")
public class BannerController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {

        return "banner/index";
    }

    @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
    public String add(HttpServletRequest request) {

        String redirect = "banner/banner-add";
        if (request.getMethod().equals(RequestMethod.POST.toString())){
            //add
            redirect = "redirect:/banner";
        }

        return redirect;
    }

    @RequestMapping(value = "{id}/update", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(HttpServletRequest request, @PathVariable String id,@ModelAttribute YyBanner banner) {

        String redirect = "banner/banner-update";
        if (request.getMethod().equals(RequestMethod.POST.toString())){
            //add
            redirect = "redirect:/banner";
        }

        return redirect;
    }

    @RequestMapping(value = "{bannerId}/del", method = RequestMethod.GET)
    public String del(@PathVariable String bannerId) {

        return "redirect:/banner";
    }


    @RequestMapping(value = "position", method = RequestMethod.GET)
    public String positionList() {

        return "banner/position";
    }

    @RequestMapping(value = "position/add", method = RequestMethod.GET)
    public String positionAdd(HttpServletRequest request) {
        String redirect = "banner/position-add";
        if (request.getMethod().equals(RequestMethod.POST.toString())){
            //add
            redirect = "redirect:/banner/position";
        }

        return redirect;
    }

    @RequestMapping(value = "position/{positionId}/update", method = RequestMethod.GET)
    public String positionAdd(HttpServletRequest request,@PathVariable String positionId, @ModelAttribute YyPosition position) {
        String redirect = "banner/position-update";
        if (request.getMethod().equals(RequestMethod.POST.toString())){
            //add
            redirect = "redirect:/banner/position";
        }

        return redirect;
    }

    @RequestMapping(value = "position/{positionId}/del", method = RequestMethod.GET)
    public String delPosition(@PathVariable String positionId) {

        return "redirect:/banner/position";
    }




}
