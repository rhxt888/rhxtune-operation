package com.operation.web.page;

import com.operation.domain.YyArticle;
import com.operation.spi.IYyArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-02-25,  下午4:45
 * @copyright : Copyright(c) 2015 北京瑞华信通信息技术有限公司
 */

@Controller
@RequestMapping("/page")
public class YyArticelController {

    @Resource
    IYyArticleService yyArticleSertice;

    @RequestMapping("article/{id}")
    public String articleDetail(@PathVariable String id, Map<String, Object> model) {

        YyArticle article = yyArticleSertice.findOne(id,true);

        model.put("content", article);

        return article.getTemplate();
    }
}
