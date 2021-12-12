package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.lzq.model.Users;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class esController {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 添加索引
     *
     * @return
     */
    @RequestMapping("/saveIndex")
    public String saveIndex() {
        try {
            CreateIndexRequest qyf = new CreateIndexRequest("qyf");
            restHighLevelClient.indices().create(qyf, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
    /**
     * 查询索引是否存在
     *
     * @return
     */
    @RequestMapping("/existIndex")
    public String existIndex() {
        try {
            GetIndexRequest qyf = new GetIndexRequest("qyf");
            boolean exists = restHighLevelClient.indices().exists(qyf, RequestOptions.DEFAULT);
            System.out.println(exists);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
    /**
     * 添加文档
     *
     * @return
     */
    @RequestMapping("/addDocument")
    public String addDocument() {
        try {
            Users user = new Users();
            user.setName("覃cc1");
            user.setAge(20);
            IndexRequest request = new IndexRequest("qyf");

            request.source(JSON.toJSONString(user), XContentType.JSON);
            request.id("1");
            IndexResponse index = restHighLevelClient.index(request, RequestOptions.DEFAULT);
            System.out.println(index.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
    @RequestMapping("getDocument")
    public String getDocument() {
        GetResponse documentFields = null;
        try {
            GetRequest qyf = new GetRequest("qyf", "1");
            documentFields = restHighLevelClient.get(qyf, RequestOptions.DEFAULT);
            System.out.println(documentFields);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return documentFields.toString();
    }
    /**
     * 更新文档
     *
     * @return
     */
    @RequestMapping("updateDocument")
    public String updateDocument() {
        UpdateResponse update = null;
        try {
            UpdateRequest qyf = new UpdateRequest("qyf", "1");
            Users users = new Users();
            users.setName("覃帅帅");

            UpdateRequest doc = qyf.doc(JSON.toJSONString(users), XContentType.JSON);
            update = restHighLevelClient.update(qyf, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return update.toString();
    }

    /**
     * 删除文档
     * @return
     */
    @RequestMapping("deleteDocument")
    public String deleteDocument() {
        try {
            DeleteRequest qyf = new DeleteRequest("qyf", "1");
            DeleteResponse delete = restHighLevelClient.delete(qyf, RequestOptions.DEFAULT);
            System.out.println(delete.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    /**
     * 批量添加文档
     * 返回false表示没有失败
     *
     * @return
     */
    @RequestMapping("saveDocuments")
    public String saveDocuments() {
        try {
            BulkRequest bulkRequest = new BulkRequest();
            List<Users> list = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                list.add(new Users("覃帅帅" + i, 20 + 2 * i));
            }

            for (int i = 0; i < list.size(); i++) {
                bulkRequest.add(new IndexRequest("qyf").id("" + i + 10086).source(JSON.toJSONString(list.get(i)), XContentType.JSON));
            }

            BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println(bulk.hasFailures());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
    /**
     * 批量查询
     *
     * @return
     */
    @RequestMapping("findList")
    public List<Users> findList() {
        List<Users> list = null;
        try {
            //构建查询器
            SearchRequest request = new SearchRequest("qyf");
            //设置查询条件
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            //多条件查询
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            //范围查询
            boolQueryBuilder.must(QueryBuilders.rangeQuery("age")
                    .gte(50).lte(90));
            //模糊匹配
            boolQueryBuilder.must(QueryBuilders.wildcardQuery("name","*1*"));
            //多条件查询放入条件中
            sourceBuilder.query(boolQueryBuilder);
            //分页, ES从第0页开始,不设置默认只会显示10条记录
            sourceBuilder.from(0);
            sourceBuilder.size(500);
            //排序
            sourceBuilder.sort("age", SortOrder.ASC);
            //将条件放入查询器
            request.source(sourceBuilder);

            //请求
            SearchResponse search = restHighLevelClient.search(request, RequestOptions.DEFAULT);
            SearchHit[] hits = search.getHits().getHits();

            list = new ArrayList<>();
            for (SearchHit hit : hits) {
                Users users = new Users();
                users.setName(hit.getSourceAsMap().get("name").toString());
                users.setAge(Integer.parseInt(hit.getSourceAsMap().get("age").toString()));

                list.add(users);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("记录数:" + list.size());
        System.out.println(list);
        return list;
    }

    /**
     *查询全部
     */
    @RequestMapping("findAll")
    public List<Users> findAll() {
        List<Users> list = null;
        try {
            //构建查询器
            SearchRequest rq = new SearchRequest("qyf");
            //设置查询条件
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            //ES从第0页开始,不设置默认只会显示10条记录
            sourceBuilder.from(0);
            sourceBuilder.size(500);
            //将条件放入查询器
            rq.source(sourceBuilder);
            SearchResponse search = restHighLevelClient.search(rq, RequestOptions.DEFAULT);
            SearchHit[] hits = search.getHits().getHits();

            list = new ArrayList<>();
            for (SearchHit hit : hits) {
                Users users = new Users();
                users.setName(hit.getSourceAsMap().get("name").toString());
                users.setAge(Integer.parseInt(hit.getSourceAsMap().get("age").toString()));

                list.add(users);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("记录数:" + list.size());
        System.out.println(list);
        return list;
    }
}
