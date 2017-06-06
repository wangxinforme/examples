package com.wangxin.solr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = ItemDocument.SOLR_COLLECTION)
public class ItemDocument implements ItemDefinition {

    @Value("${solr.collection}")
    public final static String SOLR_COLLECTION = "";

    private @Id @Indexed String id;

    private @Indexed(GOODSNAME) String goodsName;

    private @Indexed(BRANDNAME) String brandName;

    private @Indexed(WORD) String word;

    private @Indexed(GKEY) String gkey;

    private @Indexed(KEYWORDS) String keywords;

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

    @Override
    public String toString() {
        return "ItemDocument [id=" + id + ", goodsName=" + goodsName + ", brandName=" + brandName + ", word=" + word + ", gkey=" + gkey + ", keywords=" + keywords + "]";
    }

}
