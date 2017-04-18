package com.wangxin.service.simple.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangxin.common.constants.Constants;
import com.wangxin.common.db.table.FactoryAboutKey;
import com.wangxin.common.db.table.TablesPKEnum;
import com.wangxin.common.exception.BusinessException;
import com.wangxin.entity.simple.News;
import com.wangxin.mapper.simple.NewsMapper;
import com.wangxin.service.simple.NewsService;

/** 
 * @Description 新闻接口实现类
 * @author 王鑫 
 * @date Mar 16, 2017 5:19:24 PM  
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {

    private static final Logger log = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    private NewsMapper newsMapper;

    @Transactional
    @Override
    public boolean addNews(News news) {
        if (news != null) {
            news.setId(FactoryAboutKey.getPK(TablesPKEnum.T_NEWS));
            news.setCreateTime(Calendar.getInstance().getTime());
            int flag = newsMapper.insert(news);
            if (StringUtils.equals(news.getTitle(), "a"))
                throw new BusinessException("001", "测试事务回溯");
            if (flag == 1)
                return true;
            else
                return false;
        } else
            return false;
    }

    @Override
    public boolean editNews(News news) {
        if (news != null && StringUtils.isNotBlank(news.getId())) {
            int flag = newsMapper.update(news);
            if (flag == 1)
                return true;
            else
                return false;
        } else
            return false;
    }

    @Override
    public News findNewsById(String id) {
        if (StringUtils.isBlank(id))
            return null;
        else
            return newsMapper.findById(id);
    }

    // 默认数据库
    @Override
    public List<News> findNewsByKeywords(String keywords) {
        log.info("# 查询默认数据库");
        return newsMapper.findNewsByKeywords(keywords);
    }

    @Override
    public PageInfo<News> findNewsByPage(Integer pageNum, String keywords) {
        // request: url?pageNum=1&pageSize=10
        // 支持 ServletRequest,Map,POJO 对象，需要配合 params 参数
        if (pageNum == null)
            pageNum = 1;
        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        // 紧跟着的第一个select方法会被分页
        List<News> news = newsMapper.findNewsByPage(keywords);
        // 用PageInfo对结果进行包装
        PageInfo<News> page = new PageInfo<News>(news);
        // 测试PageInfo全部属性
        // PageInfo包含了非常全面的分页属性
        log.info("# 查询默认数据库 page.toString()={}", page.toString());
        return page;
    }

}
