package com.wangxin.solr;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;

public class ItemDocument implements Serializable {

    private static final long serialVersionUID = -7822381045106227359L;

    public static final String FIELD_ID = "id";
    public static final String FIELD_GOODSNAME = "goodsName";
    public static final String FIELD_BRANDNAME = "brandName";
    public static final String FIELD_WORD = "word";
    public static final String FIELD_GKEY = "gkey";
    public static final String FIELD_KEYWORDS = "keywords";

    @Field(FIELD_ID)
    private String id;

    @Field(FIELD_GOODSNAME)
    private String goodsName;

    @Field(FIELD_BRANDNAME)
    private String brandName;

    @Field(FIELD_WORD)
    private String word;

    @Field(FIELD_GKEY)
    private String gkey;

    @Field(FIELD_KEYWORDS)
    private String keywords;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getGkey() {
        return gkey;
    }

    public void setGkey(String gkey) {
        this.gkey = gkey;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

}
