package com.wangxin.service.simple;

import org.springframework.data.domain.Page;

import com.wangxin.solr.ItemDocument;

public interface ItemService {

    Page<ItemDocument> searchForPage(String keywords, int pageNum);

}
