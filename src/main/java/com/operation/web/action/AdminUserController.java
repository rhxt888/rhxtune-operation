package com.operation.web.action;

import com.operation.domain.YyAdminUser;
import com.operation.spi.IAdminUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-01,  下午2:20
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */
@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @Resource
    IAdminUserService adminUserService;

    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String signin(Map<String, Object> model) {
        model.put("time", new Date());
        return "admin/signin";
    }

    @RequestMapping(value = "do/signin", method = RequestMethod.POST)
    public ModelAndView signinPost(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) {
        ModelAndView mav = new ModelAndView();
        return mav;
    }


    @RequestMapping(value = "my", method = RequestMethod.GET)
    public ModelAndView my() {
        ModelAndView mav = new ModelAndView();
        return mav;
    }

    @RequestMapping(value = "do/save", method = RequestMethod.POST)
    public String save(@ModelAttribute YyAdminUser adminUser) {
        ModelAndView mav = new ModelAndView();
        adminUserService.save(adminUser);
        return "admin/main";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Map<String, Object> model,
                       @RequestParam(value = "keyword", required = false) String keyword,
                       @RequestParam(value = "pageSize", defaultValue = "1", required = false) Integer pageSize,
                       @RequestParam(value = "pageIndex", defaultValue = "1", required = false) Integer pageIndex) {
        model.put("adminList", adminUserService.findAll(pageSize, pageIndex, keyword));
        return "admin/main";
    }


}
