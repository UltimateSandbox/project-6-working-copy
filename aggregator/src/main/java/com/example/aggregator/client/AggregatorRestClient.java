package com.example.aggregator.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.example.aggregator.model.Entry;

@Component
public class AggregatorRestClient {

    private RestTemplate restTemplate;

    public AggregatorRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Entry getDefinitionFor(String word) {

        String uri = "http://localhost:9091/getWord/" + word;

        Entry result = restTemplate.getForObject(uri, Entry.class);

        return result;
    }
}
