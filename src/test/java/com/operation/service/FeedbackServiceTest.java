package com.operation.service;

import com.operation.ApplicationMain;
import com.operation.domain.YyFeedback;
import com.operation.domain.YyFeedbackCate;
import com.operation.domain.YyFeedbackPre;
import com.operation.spi.IFeedbackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ApplicationMain.class)
public class FeedbackServiceTest {
    @Resource
    IFeedbackService iFeedbackService;
    @Test
    public void testSaveCate() throws Exception {
        YyFeedbackCate yyFeedbackCate =new YyFeedbackCate();
        yyFeedbackCate.setName("name");
        yyFeedbackCate.setAppSlug("app");
        iFeedbackService.saveCate(yyFeedbackCate);
    }

    @Test
    public void testSavePre() throws Exception {
        YyFeedbackPre yyFeedbackPre =new YyFeedbackPre();
        yyFeedbackPre.setAppSlug("app");
        yyFeedbackPre.setContent("Content");
        yyFeedbackPre.setCate(new YyFeedbackCate());
    }

    @Test
    public void testSave() throws Exception {
        YyFeedback yyFeedback =new YyFeedback() ;

    }

    @Test
    public void testFindAllCate() throws Exception {

    }

    @Test
    public void testFindAllCate1() throws Exception {
        List<YyFeedbackCate> allCate = iFeedbackService.findAllCate();
        for(YyFeedbackCate yyFeedbackCate :allCate){
            System.out.println(yyFeedbackCate);
        }
    }

    @Test
    public void testFindAllPre() throws Exception {

    }

    @Test
    public void testFindCateByAppSlug() throws Exception {

    }

    @Test
    public void testFindPreByAppSlug() throws Exception {

    }

    @Test
    public void testFindCateByName() throws Exception {

    }

    @Test
    public void testFindCateByNameAndAppSlug() throws Exception {

    }
}