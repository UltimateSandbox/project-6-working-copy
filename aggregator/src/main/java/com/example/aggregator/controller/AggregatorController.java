package com.example.aggregator.controller;

import com.example.aggregator.model.Entry;
import com.example.aggregator.service.AggregatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AggregatorController {

    private static final Logger logger = LoggerFactory.getLogger(AggregatorController.class);

    private AggregatorService service;

    public AggregatorController(AggregatorService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Entry> helloWorld() {

        List<Entry> entries = new ArrayList<>();
        entries.add(service.getDefinitionFor("hello"));
        entries.add(service.getDefinitionFor("world"));
        return entries;
    }

    @GetMapping("/getDefinitionFor/{word}")
    public Entry getDefinitionFor(@PathVariable String word) {
        return this.service.getDefinitionFor(word);
    }
}
