package com.xyh.game.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class TestEs {
    public static void main(String[] args) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.2.129",9200,"http"))
        );
    }
}
