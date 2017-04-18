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
        for (int i = 1; i < 1001; i++) {
            news = new News();
            news.setTitle("news_" + i);
            news.setDescription("news_" + i);
            news.setAddress("news_" + i);
            news.setNewsTime(Calendar.getInstance().getTime());
            newsService.addNews(news);
        }

    }
}
