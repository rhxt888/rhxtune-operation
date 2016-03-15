package com.operation.web.action;

import com.operation.domain.YyBanner;
import com.operation.domain.YyPosition;
import com.operation.spi.IAdminUserService;
import com.operation.spi.IMcommunityService;
import com.operation.spi.IYyAppService;
import com.operation.spi.IYyBannerService;
import com.rhxtune.base.provider.dao.mongo.CommunityDao;
import com.rhxtune.base.spi.community.ICommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.SimpleFormatter;

/**
 * @author : Hui.Wang [wang.hui@rhxtune.com]
 * @version : 1.0
 * @created on  : 2016-03-03,  下午3:41
 * @copyright : Copyright(c) 2015  北京瑞华信通信息技术有限公司
 */

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Resource
    IYyAppService yyAppService;

    @Resource
    IYyBannerService yyBannerService;
    @Resource
    ICommunityService communityService;
    @Resource
    IAdminUserService adminUserService;
    @Resource
    IMcommunityService mcommunityService;


    /**
     * 查询banner列表
     * @param model
     * @param pageIndex
     * @param pageSize
     * @param keyword
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Map<String, Object> model,
                        @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                        @RequestParam(value = "keyword", required = false) String keyword) {
        model.put("bannerList", yyBannerService.findAll(pageSize, pageIndex, keyword));
        return "banner/index";
    }


    /**
     * 添加banner
     * @param request
     * @param yyBanner
     * @param startTimeStr
     * @param endTimeStr
     * @param model
     * @param pageIndex
     * @param pageSize
     * @param keyword
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String add(HttpServletRequest request,
                      @ModelAttribute YyBanner yyBanner,
                      String startTimeStr,
                      String endTimeStr,
                      Map<String,Object> model,
                      @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
                      @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                      @RequestParam(value = "keyword", required = false) String keyword
    ) throws ParseException {
        String redirect = "banner/banner-add";
        if (request.getMethod().equals(RequestMethod.POST.toString())) {
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            Date startTime = sdf.parse(startTimeStr);
            Date endTime = sdf.parse(endTimeStr);
            yyBanner.setStartTime(startTime.getTime());
            yyBanner.setEndTime(endTime.getTime());
            yyBanner.setViewCount(0l);
            yyBanner.setCreatedTime(new Date().getTime());
            yyBanner.setDeleted(false);

            yyBannerService.save(yyBanner);
            redirect = "redirect:/banner";
        }else{
            model.put("appList",yyAppService.findAll());
            model.put("positionList", yyBannerService.findAllPosition());
            model.put("adminUserList",adminUserService.findAll());
//            model.put("communityList",mcommunityService.findAll());
        }

        return redirect;
    }


    /**
     * 修改banner
     * @param request
     * @param id
     * @param banner
     * @return
     */
    @RequestMapping(value = "{id}/update", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(HttpServletRequest request,
                         @PathVariable String id,
                         @ModelAttribute YyBanner banner,
                         Map<String,Object> model) {

        String redirect = "banner/banner-update";
        if (request.getMethod().equals(RequestMethod.POST.toString())) {
            //add
            redirect = "redirect:/banner";
        }else {
            model.put("appList",yyAppService.findAll());
            model.put("banner",yyBannerService.findBannerById(id));
            model.put("positionList",yyBannerService.findAllPosition());
        }
        return redirect;
    }

    /**
     * 删除banner
     * @param bannerId
     * @return
     */
    @RequestMapping(value = "{bannerId}/del", method = RequestMethod.GET)
    public String del(@PathVariable String bannerId) {

        return "redirect:/banner";
    }


    /**
     * 查询position
     * @param model
     * @param pageIndex
     * @param pageSize
     * @param keyword
     * @return
     */
    @RequestMapping(value = "position", method = RequestMethod.GET)
    public String positionList(Map<String, Object> model,
                               @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                               @RequestParam(value = "keyword", required = false) String keyword) {
        model.put("positionList", yyBannerService.findAllPosition(pageSize,pageIndex,keyword));
        model.put("appList",yyAppService.findAll());
        return "banner/position";
    }

    @RequestMapping(value = "position/{positionId}", method = RequestMethod.GET)
    public String positionDetial(@PathVariable String positionId,Map<String,Object> model) {
        model.put("position",yyBannerService.findPositionById(positionId));
        return "banner/position-detail";
    }

    @RequestMapping(value = "position/add", method = {RequestMethod.GET,RequestMethod.POST})
    public String positionAdd(HttpServletRequest request,
                              Map<String,Object> model,
                              @ModelAttribute YyPosition position,
                              @RequestParam(required = false) String appId) {
        String redirect = "banner/position-add";
        if (request.getMethod().equals(RequestMethod.POST.toString())) {
            //add
            position.setAppInfo(yyAppService.findOne(appId));
            yyBannerService.savePosition(position);
            redirect = "redirect:/banner/position";
        } else {
            model.put("appList",yyAppService.findAll());
        }

        return redirect;
    }

    @RequestMapping(value = "position/{positionId}/update", method = {RequestMethod.GET,RequestMethod.POST})
    public String positionAdd(HttpServletRequest request,
                              Map<String,Object> model,
                              @PathVariable String positionId,
                              @RequestParam(required = false) String appId,
                              @ModelAttribute YyPosition position) {
        String redirect = "banner/position-update";
        if (request.getMethod().equals(RequestMethod.POST.toString())) {
            //update
            position.setAppInfo(yyAppService.findOne(appId));
            yyBannerService.updatePosition(position);
            redirect = "redirect:/banner/position";
        } else {

            model.put("appList",yyAppService.findAll());
            model.put("position",yyBannerService.findPositionById(positionId));
        }

        return redirect;
    }

    @RequestMapping(value = "position/{positionId}/del", method = RequestMethod.GET)
    public String delPosition(@PathVariable String positionId) {
        yyBannerService.deletePosition(positionId);
        return "redirect:/banner/position";
    }


}
