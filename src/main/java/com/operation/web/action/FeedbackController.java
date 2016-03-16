package com.operation.web.action;

import com.operation.domain.YyFeedbackCate;
import com.operation.spi.IFeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-03,  下午7:02
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Resource
    IFeedbackService feedbackService;

    /**
     * 查询所有的用户反馈
     * @param model
     * @param keyword
     * @param pageSize
     * @param pageIndex
     * @return
     */
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(Map<String, Object> model,
                        @RequestParam(value = "keyword", required = false) String keyword,
                        @RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize,
                        @RequestParam(value = "pageIndex", defaultValue = "1", required = false) Integer pageIndex){
        model.put("feedbackCate", feedbackService.findAllCate(pageSize, pageIndex, keyword));
        return "feedback/index";
    }

    /**
     * 查询所有的用户类型
     * @return
     */
    @RequestMapping(value="findAllCate",method = RequestMethod.GET)
    public String findAllCate(Model model){
        List<YyFeedbackCate>yyFeedbackCates=feedbackService.findAllCate();
        model.addAttribute("yyFeedbackCates",yyFeedbackCates);
        return null;
    }

    /**
     * 根据app和分类进行查询
     * @return
     */
    @RequestMapping(value="findCateByNameAndAppSlug",method = RequestMethod.GET)
    public String findCateByNameAndAppSlug(Model model,String name,String appslug){
        if(appslug==null) {
            List<YyFeedbackCate> feedbackCate = feedbackService.findCateByName(name);
            model.addAttribute("feedback",feedbackCate);
        }else if(name==null){
            List<YyFeedbackCate> feedbackCate = feedbackService.findCateByAppSlug(appslug);
            model.addAttribute("feedback",feedbackCate);
        }
        List<YyFeedbackCate> feedbackCate = feedbackService.findCateByNameAndAppSlug(name,appslug);
        model.addAttribute("feedback",feedbackCate);
        return "feedback/index";
    }
}
