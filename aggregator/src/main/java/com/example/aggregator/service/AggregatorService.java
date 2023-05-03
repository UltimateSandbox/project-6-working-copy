package com.example.aggregator.service;

import com.example.aggregator.client.AggregatorRestClient;
import com.example.aggregator.model.Entry;
import org.springframework.stereotype.Service;

@Service
public class AggregatorService {

    private AggregatorRestClient restClient;

    public AggregatorService(AggregatorRestClient restClient) {
        this.restClient = restClient;
    }

    public Entry getDefinitionFor(String word) {
        return restClient.getDefinitionFor(word);
    }
 }
