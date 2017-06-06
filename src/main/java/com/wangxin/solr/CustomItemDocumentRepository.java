package com.wangxin.solr;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomItemDocumentRepository extends SolrCrudRepository<ItemDocument, String> {

    // @Highlight(prefix = "<b>", postfix = "</b>")
    // @Query(fields = { ItemDefinition.KEYWORDS }, defaultOperator = Operator.AND)
    // public Page<ItemDocument> searchForPage(Collection<String> keywords, Pageable page);

    // @Query(fields = "goodsName", defaultOperator = Operator.AND)
    // @Query("select t from ItemDocument t")
    // Page<ItemDocument> findAll(Collection<String> keywords, Pageable page);
    Page<ItemDocument> findAll(Pageable page);

    Page<ItemDocument> findByGoodsName(String goodsName, Pageable page);

}
