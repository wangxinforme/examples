package com.wangxin.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wangxin.entity.simple.News;
import com.wangxin.service.simple.NewsService;

/** 
 * @Description 新闻示例
 * @author 王鑫 
 * @date Mar 16, 2017 3:58:01 PM  
 */
@Controller
public class NewsController {

    private static final Logger log = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    /*
     * 表单提交日期绑定
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/news/master/add", method = RequestMethod.GET)
    public String master_add() {
        log.info("# 进入发布新闻页面");
        return "news/master_add";
    }

    @RequestMapping(value = "/news/master/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> master_add(@ModelAttribute("newsForm") News news) {
        boolean flag = newsService.addMasterNews(news);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg", "发布成功");
        } else {
            result.put("status", "0");
            result.put("msg", "发布失败");
        }
        return result;
    }

    @RequestMapping(value = "/news/master/load/{id}", method = RequestMethod.GET)
    public String master_load(@PathVariable String id, ModelMap map) {
        log.info("# ajax加载新闻对象");
        News news = newsService.findMasterNewsById(id);
        map.addAttribute("news", news);
        return "news/edit_form";
    }

    @RequestMapping(value = "/news/master/edit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> master_edit(@ModelAttribute("newsForm") News news) {
        boolean flag = newsService.editMasterNews(news);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg", "发布成功");
        } else {
            result.put("status", "0");
            result.put("msg", "发布失败");
        }
        return result;
    }

    @RequestMapping(value = "/news/master/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> master_delte(@PathVariable String id) {
        boolean flag = newsService.deleteMasterNewsById(id);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg", "删除成功");
        } else {
            result.put("status", "0");
            result.put("msg", "删除失败");
        }
        return result;
    }

    @RequestMapping(value = "/news/master/list", method = RequestMethod.GET)
    public String master_list(ModelMap map) {
        PageInfo<News> page = newsService.findMasterNewsByPage(null, null);
        map.put("page", page);
        return "news/master_list";
    }

    @RequestMapping(value = "/news/master/list_page", method = RequestMethod.POST)
    public String master_list_page(@RequestParam(value = "keywords", required = false) String keywords, @RequestParam(value = "pageNum", required = false) Integer pageNum, ModelMap map) {
        log.info("#分页查询新闻 pageNum={} , keywords={}", pageNum, keywords);
        PageInfo<News> page = newsService.findMasterNewsByPage(pageNum, keywords);
        map.put("page", page);
        map.put("keywords", keywords);
        return "news/master_list_page";
    }

    @RequestMapping(value = "/news/slave/add", method = RequestMethod.GET)
    public String slave_add() {
        log.info("# 进入发布新闻页面");
        return "news/slave_add";
    }

    @RequestMapping(value = "/news/slave/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> slave_add(@ModelAttribute("newsForm") News news) {
        boolean flag = newsService.addSlaveNews(news);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg", "发布成功");
        } else {
            result.put("status", "0");
            result.put("msg", "发布失败");
        }
        return result;
    }

    @RequestMapping(value = "/news/slave/load/{id}", method = RequestMethod.GET)
    public String slave_load(@PathVariable String id, ModelMap map) {
        log.info("# ajax加载新闻对象");
        News news = newsService.findSlaveNewsById(id);
        map.addAttribute("news", news);
        return "news/edit_form";
    }

    @RequestMapping(value = "/news/slave/edit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> slave_edit(@ModelAttribute("newsForm") News news) {
        boolean flag = newsService.editSlaveNews(news);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg", "发布成功");
        } else {
            result.put("status", "0");
            result.put("msg", "发布失败");
        }
        return result;
    }

    @RequestMapping(value = "/news/slave/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> slave_delte(@PathVariable String id) {
        boolean flag = newsService.deleteSlaveNewById(id);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg", "删除成功");
        } else {
            result.put("status", "0");
            result.put("msg", "删除失败");
        }
        return result;
    }

    @RequestMapping(value = "/news/slave/list", method = RequestMethod.GET)
    public String slave_list(ModelMap map) {
        PageInfo<News> page = newsService.findSlaveNewsByPage(null, null);
        map.put("page", page);
        return "news/slave_list";
    }

    @RequestMapping(value = "/news/slave/list_page", method = RequestMethod.POST)
    public String slave_list_page(@RequestParam(value = "keywords", required = false) String keywords, @RequestParam(value = "pageNum", required = false) Integer pageNum, ModelMap map) {
        log.info("#分页查询新闻 pageNum={} , keywords={}", pageNum, keywords);
        PageInfo<News> page = newsService.findSlaveNewsByPage(pageNum, keywords);
        map.put("page", page);
        map.put("keywords", keywords);
        return "news/slave_list_page";
    }

}
