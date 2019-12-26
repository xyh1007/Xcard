package com.xyh.game.elasticsearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EUserService {

    private RestHighLevelClient client;


    private ObjectMapper objectMapper;

    @Autowired
    public EUserService(@Qualifier("restClient") RestHighLevelClient client, ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    public boolean indexIsExist(String name) throws IOException {
        GetIndexRequest request = new GetIndexRequest(name);
        return client.indices().exists(request, RequestOptions.DEFAULT);
    }
}
