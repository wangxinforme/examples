package com.wangxin.solr;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wangxin.entity.simple.Item;

public interface CustomItemDocumentRepository  {

    public void update(Item item);

    public ItemDocument buildDocument(Item item);

    public Page<ItemDocument> searchForPage(String keywords, Pageable page);

    public void deleteAllItemDocument();

}
