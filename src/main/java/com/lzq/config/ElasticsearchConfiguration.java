package com.lzq.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* spring-data-elasticsearch使用RestHighLevelClient进行搜索引擎ES操作 cluster-name过时 cluster-nodes过时
* 官方将在未来的8.0版本后移除之前的api 推荐使用RestHighLevelClient
* */
@Configuration
public class ElasticsearchConfiguration {
    @Bean
    public RestHighLevelClient client(){
        RestHighLevelClient restClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200)));
        return restClient;
    }
}
