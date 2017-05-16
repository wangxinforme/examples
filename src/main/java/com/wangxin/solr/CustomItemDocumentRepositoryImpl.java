package com.wangxin.solr;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.DefaultQueryParser;
import org.springframework.data.solr.core.QueryParser;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.server.support.HttpSolrClientFactory;
import org.springframework.stereotype.Repository;

import com.wangxin.entity.simple.Item;

@Repository("customItemDocumentRepository")
public class CustomItemDocumentRepositoryImpl implements CustomItemDocumentRepository {

    private static final Logger logger = LoggerFactory.getLogger(CustomItemDocumentRepositoryImpl.class);

    private SolrTemplate solrTemplate;

    private SolrClient solrClient;

    private QueryParser queryParser = new DefaultQueryParser();

    @Value("#{configProperties['solr.connection']}")
    private String zkHost;

    @Value("#{configProperties['solr.collection']}")
    private String defaultCollection;

    @Value("#{configProperties['solr.zk.client.timeout']}")
    private int zkClientTimeout;

    @Value("#{configProperties['solr.zk.connect.timeout']}")
    private int zkConnectTimeout;

    @PostConstruct
    public void init() {
        logger.debug("# zkHost={} , defaultCollection={} , zkClientTimeout={} , zkConnectTimeout={}", zkHost, defaultCollection, zkClientTimeout, zkConnectTimeout);
        CloudSolrClient client = new CloudSolrClient(zkHost);
        client.setDefaultCollection(defaultCollection);
        client.setZkClientTimeout(zkClientTimeout);
        client.setZkConnectTimeout(zkConnectTimeout);
        solrClient = client;

        solrTemplate = new SolrTemplate(solrClient, defaultCollection);
    }

    @Override
    public void update(Item item) {
        // TODO Auto-generated method stub

    }

    @Override
    public ItemDocument buildDocument(Item item) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<ItemDocument> searchForPage(String keywords, Pageable page) {
        Query search = null;
        if (StringUtils.isNotBlank(keywords))
            search = createQueryByWords(StringUtils.split(keywords, " "));
        else
            search = new SimpleQuery(Criteria.where(ItemDocument.FIELD_KEYWORDS).is("s"));

        if (page != null)
            search.setPageRequest(page);

        String queryString = queryParser.getQueryString(search);
        if (logger.isDebugEnabled()) {
            logger.debug("## execute sorl query string:[{}]", queryString);
        }

        return solrTemplate.queryForPage(search, ItemDocument.class);

        // SolrQuery query = new SolrQuery("*:*");
        // try {
        // QueryResponse rsp = solrClient.query(query, METHOD.POST);
        //
        // SolrDocumentList docs = rsp.getResults();
        // System.out.println(JSON.toJSONString(docs));
        // } catch (SolrServerException | IOException e) {
        // e.printStackTrace();
        // return null;
        // } finally {
        // }

        // return null;
    }

    /**
     * 创建词条对象
     *
     * @param word
     * @return
     * @author wangxin
     */
    private Criteria createCriteriaByWords(String word) {
        return Criteria.where(ItemDocument.FIELD_KEYWORDS).is(word);
    }

    /**
     * 词条对象追加词条
     *
     * @param word
     * @return
     * @author wangxin
     */
    private Criteria appendCriteriaWords(Criteria c, String word) {
        return c.or(ItemDocument.FIELD_KEYWORDS).is(word);
    }

    private Query createQueryByWords(String[] words) {
        Query query = new SimpleQuery();
        if (ArrayUtils.isNotEmpty(words)) {
            Criteria c2 = null;

            for (String word : words) {
                if (StringUtils.isBlank(word)) {
                    continue;
                }
                if (c2 == null) {
                    c2 = createCriteriaByWords(word);
                } else {
                    c2 = appendCriteriaWords(c2, word);
                }
            }
            if (c2 != null)
                query = new SimpleQuery(c2);
            else
                query = new SimpleQuery(Criteria.where(ItemDocument.FIELD_KEYWORDS).is("s"));
        }
        return query;
    }

    @Override
    public void deleteAllItemDocument() {
        // TODO Auto-generated method stub

    }

}
