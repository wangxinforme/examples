package com.wangxin.solr;

public interface ItemDefinition {

    String ID = "id";
    String GOODSNAME = "goodsName";
    String BRANDNAME = "brandName";
    String WORD = "word";
    String GKEY = "gkey";
    String KEYWORDS = "keywords";

    // For Query
    String QUERY_GOODSNAME = "_goodsName";
    String QUERY_BRANDNAME = "_brandName";
    String QUERY_WORD = "_word";
    String QUERY_GKEY = "_gkey";
    String QUERY_KEYWORDS = "keywords";
}
