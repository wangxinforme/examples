package com.wangxin.entity.simple;

import java.io.Serializable;

public class Item implements Serializable {

    private static final long serialVersionUID = -3938555491314951580L;

    private String id;

    private String goodsName;

    private String brandName;

    private String word;

    private String gkey;

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
