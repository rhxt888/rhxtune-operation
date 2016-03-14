package com.operation.web.action;

import com.operation.config.WebConfiguration;
import com.operation.domain.YyAdminUser;
import com.operation.domain.YyApp;
import com.operation.domain.YyBanner;
import com.operation.spi.IYyAppService;
import com.operation.spi.IYyArticleService;
import com.operation.web.utils.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-03,  下午3:41
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */
@Controller
@RequestMapping("/app")
public class AppController {
    @Resource
    WebConfiguration webConfig;

    @Resource
    SessionUtil sessionUtil;

    @Resource
    IYyArticleService yyArticleService;

    @Resource
    IYyAppService yyAppService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(
            @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(value = "status", required = false, defaultValue = "dev") String status,
            @RequestParam(value = "isDeleted", required = false, defaultValue = "false") Boolean isDeleted,
            @RequestParam(value = "keyword", required = false) String keyword,
            Map<String, Object> model) {
        model.put("appList", yyAppService.findAll(pageSize, pageIndex, status, isDeleted, keyword));
        return "app/index";
    }

    @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
    public String add(HttpServletRequest request,
                      Map<String, Object> model,
                      @ModelAttribute YyApp app,
                      @RequestParam(required = false) String articleId) {

        String redirect = "app/app-add";
        if (request.getMethod().equals(RequestMethod.POST.toString())) {
            //add
            YyAdminUser adminUser = sessionUtil.getSessionUser();
            app.setAdminUser(adminUser);
            app.setAgreementUrl(webConfig.getPagePrefix() + articleId);
            yyAppService.save(app);
            redirect = "redirect:/app";
        } else {
            model.put("artileList", yyArticleService.findByTemplate("agreement"));
        }

        return redirect;
    }

    @RequestMapping(value = "{id}/update", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(HttpServletRequest request,
                         Map<String, Object> model,
                         @PathVariable String id,
                         @ModelAttribute YyApp app,
                         @RequestParam(required = false) String articleId) {

        String redirect = "app/app-update";
        if (request.getMethod().equals(RequestMethod.POST.toString())) {
            //update
            YyAdminUser adminUser = sessionUtil.getSessionUser();
            app.setAdminUser(adminUser);
            app.setAgreementUrl(webConfig.getPagePrefix() + articleId);
            yyAppService.update(app);
            redirect = "redirect:/app";
        } else {
            model.put("artileList", yyArticleService.findByTemplate("agreement"));
            model.put("app", yyAppService.findOne(id));
        }


        return redirect;
    }

    @RequestMapping(value = "{appId}/del", method = RequestMethod.GET)
    public String del(@PathVariable String appId) {
        yyAppService.delete(appId);
        return "redirect:/app";
    }

    @RequestMapping(value = "{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String findById(@PathVariable String id, Map<String, Object> model) {
        String redirect = "app/detail";
        model.put("app", yyAppService.findOne(id));
        return redirect;
    }
}
