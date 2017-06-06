package com.wangxin.service.simple.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.wangxin.service.simple.ItemService;
import com.wangxin.solr.CustomItemDocumentRepository;
import com.wangxin.solr.ItemDocument;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    private static final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private CustomItemDocumentRepository customItemDocumentRepository;

    private static final Pattern IGNORED_CHARS_PATTERN = Pattern.compile("\\p{Punct}");

    @Override
    public Page<ItemDocument> searchForPage(String keywords, int pageNum) {
        // Sort st = null;
        // if (!queryType) {
        // st = new Sort(Sort.Direction.DESC, PmTermDocument.FIELD_SEARCH_HOT);
        // }
        // Pageable page = new PageRequest(pageNumber, pageSize, st);
        Pageable page = new PageRequest(pageNum, 10);
        List<String> result = null;
        if (StringUtils.isNotBlank(keywords)) {
            result = new ArrayList<>();
            String[] searchTerms = StringUtils.split(keywords, " ");
            result = new ArrayList<String>(searchTerms.length);
            for (String term : searchTerms) {
                if (StringUtils.isNotEmpty(term)) {
                    result.add(IGNORED_CHARS_PATTERN.matcher(term).replaceAll(" "));
                }
            }
        }
        log.debug("# keywords={}", JSON.toJSONString(result));
        Page<ItemDocument> p = customItemDocumentRepository.findAll(page);
        log.debug("# {}", JSON.toJSONString(p));
        return p;
        // List<ItemDocument> list = customItemDocumentRepository.findAll();
        // log.debug("# list={}", JSON.toJSONString(list));
        // return null;
    }

}
