package com.operation.web.action;

import com.operation.domain.YyAdminUser;
import com.operation.domain.YyArticle;
import com.operation.domain.YyBanner;
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
 * @created on  : 2016-03-03,  下午7:58
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */

@Controller
@RequestMapping("/content")
public class ContentController {

    @Resource
    IYyArticleService yyArticleService;

    @Resource
    SessionUtil sessionUtil;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                        @RequestParam(value = "status", required = false, defaultValue = "online") String status,
                        @RequestParam(value = "isDeleted", required = false, defaultValue = "false") Boolean isDeleted,
                        @RequestParam(value = "keyword", required = false) String keyword,
                        Map<String, Object> model) {
        model.put("articleList", yyArticleService.findAll(pageSize,pageIndex, status,isDeleted, keyword));
        return "content/index";
    }

    @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
    public String add(HttpServletRequest request, @ModelAttribute YyArticle yyArticle) {

        String redirect = "content/article-add";
        if (request.getMethod().equals(RequestMethod.POST.toString())) {
            //add
            YyAdminUser adminUser = sessionUtil.getSessionUser();
            yyArticle.setAdminUser(adminUser);
            yyArticleService.save(yyArticle);
            redirect = "redirect:/content";
        }

        return redirect;
    }

    @RequestMapping(value = "{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String findById( @PathVariable String id, Map<String,Object> model) {
        String redirect = "content/detail";
        model.put("article",yyArticleService.findOne(id,false));
        return redirect;
    }

    @RequestMapping(value = "{id}/update", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(HttpServletRequest request,
                         @PathVariable String id,
                         @ModelAttribute YyArticle article,
                         Map<String,Object> model) {

        String redirect = "content/article-update";
        if (request.getMethod().equals(RequestMethod.POST.toString())) {
            //add
            yyArticleService.update(article);
            redirect = "redirect:/content";
        } else {
            model.put("article",yyArticleService.findOne(id,false));
        }

        return redirect;
    }

    @RequestMapping(value = "{articleId}/del", method = RequestMethod.GET)
    public String del(@PathVariable String articleId) {

        return "redirect:/content";
    }

}
