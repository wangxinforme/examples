package com.wangxin.service.simple;

import com.github.pagehelper.PageInfo;
import com.wangxin.entity.simple.News;

/** 
 * @Description 新闻接口类
 * @author 王鑫 
 * @date Mar 16, 2017 5:19:14 PM  
 */
public interface NewsService {

    // ---- master
    public boolean addMasterNews(News news);

    public boolean editMasterNews(News news);

    public boolean deleteMasterNewsById(String id);

    public News findMasterNewsById(String newsId);

    public PageInfo<News> findMasterNewsByPage(Integer pageNum, String keywords);

    // ---- slave
    public boolean addSlaveNews(News news);

    public boolean editSlaveNews(News news);

    public boolean deleteSlaveNewById(String id);

    public News findSlaveNewsById(String newsId);

    public PageInfo<News> findSlaveNewsByPage(Integer pageNum, String keywords);

}