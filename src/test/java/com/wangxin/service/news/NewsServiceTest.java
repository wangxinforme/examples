package com.wangxin.service.news;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wangxin.entity.simple.News;
import com.wangxin.service.simple.NewsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml", "classpath:/spring/applicationContext-dao.xml" })
public class NewsServiceTest {

    private static final Logger log = LoggerFactory.getLogger(NewsServiceTest.class);

    @Autowired
    private NewsService newsService;

    @Test
    public void addNews() {
        log.info("# 生成测试数据");
        News news = null;
        for (int i = 1; i < 91; i++) {
            news = new News();
            news.setTitle("master_" + i);
            news.setDescription("master_" + i);
            news.setAddress("master_" + i);
            news.setNewsTime(Calendar.getInstance().getTime());
            newsService.addMasterNews(news);
        }

        for (int i = 1; i < 91; i++) {
            news = new News();
            news.setTitle("slave_" + i);
            news.setDescription("slave_" + i);
            news.setAddress("slave_" + i);
            news.setNewsTime(Calendar.getInstance().getTime());
            newsService.addSlaveNews(news);
        }

    }
}
