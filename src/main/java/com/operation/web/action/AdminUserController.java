package com.operation.web.action;

import com.operation.config.WebConfiguration;
import com.operation.domain.YyAdminUser;
import com.operation.domain.YyAdminUserLog;
import com.operation.spi.IAdminUserService;
import com.operation.web.utils.RequestUtil;
import com.operation.web.utils.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    @Resource
    WebConfiguration webConfig;
    @Resource
    SessionUtil sessionUtil;

    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String signin(Map<String, Object> model) {
        model.put("time", new Date());
        return "admin/signin";
    }

    @RequestMapping(value = "signin", method = RequestMethod.POST)
    public ModelAndView signinPost(
            HttpServletRequest request,
            RedirectAttributes redirectAttributes,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) {
        String resultMessage = "登陆失败";
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:signin");
        YyAdminUser yyAdminUser = adminUserService.signin(email, password);
        if (null != yyAdminUser) {
            //登陆成功
            sessionUtil.setSessionUser(webConfig.getSessionName(), yyAdminUser);
            resultMessage = "登陆成功";
            mav.setViewName("redirect:my");
        } else {
//            是否是系统初始化后第一次登陆;
            if (adminUserService.findByEmail(webConfig.getAdminEmail()) == null) {
                String pass = webConfig.getAmdinPassword();
                String em = webConfig.getAdminEmail();
                String se = webConfig.getSessionName();
                System.out.println(em);
                if (email.equals(webConfig.getAdminEmail()) && password.equals(webConfig.getAmdinPassword())) {
                    yyAdminUser = new YyAdminUser();
                    yyAdminUser.setPassword(password);
                    yyAdminUser.setEmail(email);
                    yyAdminUser.setScreenName("系统管理员");
                    yyAdminUser.setRole("admin");
                    YyAdminUser ydu = adminUserService.save(yyAdminUser);
                    sessionUtil.setSessionUser(webConfig.getSessionName(), ydu);
                    resultMessage = "登陆成功";
                    mav.setViewName("redirect:my");
                }
            }

        }

        redirectAttributes.addAttribute("message", resultMessage);
        //记录登陆日志
        YyAdminUserLog yyAdminUserLog = new YyAdminUserLog();
        yyAdminUserLog.setAgents(RequestUtil.getUserAgent());
        yyAdminUserLog.setIp(RequestUtil.getClientIP());
        yyAdminUserLog.setSessionId(sessionUtil.getSessionId());
        yyAdminUserLog.setAdminUser(yyAdminUser);
        yyAdminUserLog.setRemark(resultMessage);

        adminUserService.recordLog(yyAdminUserLog);
        return mav;
    }


    @RequestMapping(value = "my", method = RequestMethod.GET)
    public ModelAndView my(
            @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "keyword", required = false) String keyWord,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/my");
        YyAdminUser yyAdminUser = sessionUtil.getSessionUser();
        mav.addObject("signinLogList", adminUserService.findSigninLogById(yyAdminUser.getId().toHexString(), 1, 10));

        return mav;
    }


    @RequestMapping(value = "save", method = RequestMethod.GET)
    public String savePage(@RequestParam(value = "id", required = false) String id, Map<String, Object> model) {

        if (null != id && !"".equals(id)) {
            model.put("adminInfo", adminUserService.findById(id));

            return "admin/update";
        } else {

            return "admin/save";
        }

    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute YyAdminUser adminUser, RedirectAttributes redirectAttributes) {
        String redirect = "redirect:/admin";
        if (null == adminUser.getId()) {
            YyAdminUser adminUser1 = adminUserService.findByEmail(adminUser.getEmail());
            if (null == adminUser1) {
                adminUserService.save(adminUser);
            } else {
                redirectAttributes.addAttribute("message", "email不能重复");
                redirect = "redirect:/admin/save";
            }
        } else {
            adminUserService.update(adminUser);
        }

        return redirect;
    }

    @RequestMapping(value = "update/password", method = {RequestMethod.POST, RequestMethod.GET})
    public String updatePassword(HttpServletRequest request,String id, @ModelAttribute YyAdminUser adminUser) {
        String redirect = "admin/updatePassword";
        if (request.getMethod().equals(RequestMethod.POST.toString())){
            adminUserService.updatePasswordById(adminUser.getId().toHexString(),adminUser.getPassword());
            redirect = "redirect:/admin";
        }

        return redirect;
    }

    @RequestMapping(value = "{adminId}/del", method = RequestMethod.GET)
    public String my(@PathVariable String adminId) {
        adminUserService.delete(adminId);
        return "redirect:/admin";
    }

    /**
     * 管理员列表
     *
     * @param model
     * @param keyword
     * @param pageSize
     * @param pageIndex
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Map<String, Object> model,
                        @RequestParam(value = "keyword", required = false) String keyword,
                        @RequestParam(value = "pageSize", defaultValue = "12", required = false) Integer pageSize,
                        @RequestParam(value = "pageIndex", defaultValue = "1", required = false) Integer pageIndex) {
        model.put("adminList", adminUserService.findAll(pageSize, pageIndex, keyword));
        return "admin/index";
    }


}
