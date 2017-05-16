package com.wangxin.service.simple.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wangxin.service.simple.ItemService;
import com.wangxin.solr.CustomItemDocumentRepository;
import com.wangxin.solr.ItemDocument;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    // @Autowired
    // private ItemDocumentRepository itemDocumentRepository;

    @Autowired
    private CustomItemDocumentRepository customItemDocumentRepository;

    @Override
    public Page<ItemDocument> searchForPage(String keywords, int pageNum) {
        // Sort st = null;
        // if (!queryType) {
        // st = new Sort(Sort.Direction.DESC, PmTermDocument.FIELD_SEARCH_HOT);
        // }
        // Pageable page = new PageRequest(pageNumber, pageSize, st);
        Pageable page = new PageRequest(pageNum, 10);
        return customItemDocumentRepository.searchForPage(keywords, page);
    }

}
