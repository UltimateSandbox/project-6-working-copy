package com.example.aggregator.controller;

import com.example.aggregator.model.Entry;
import com.example.aggregator.service.AggregatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AggregatorController {

    private static final Logger logger = LoggerFactory.getLogger(AggregatorController.class);

    private final AggregatorService service;

    public AggregatorController(AggregatorService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Entry> helloWorld() {

        List<Entry> entries = new ArrayList<>();

        StopWatch sw = new StopWatch();
        sw.start();
        entries.add(service.getDefinitionFor("hello"));
        entries.add(service.getDefinitionFor("world"));
        sw.stop();

        long nanoSeconds = sw.getLastTaskTimeNanos();
        String message = new StringBuilder().append("Retrieved hello world")
                .append(" containing ")
                .append(entries.size())
                .append(" entries in ")
                .append(nanoSeconds / 1000000.0)
                .append("ms")
                .toString();
        logger.info(message);

        return entries;
    }

    @GetMapping("/getDefinitionFor/{word}")
    public Entry getDefinitionFor(@PathVariable String word) {

        StopWatch sw = new StopWatch();
        sw.start();
        Entry entry = service.getDefinitionFor(word);
        sw.stop();

        long nanoSeconds = sw.getLastTaskTimeNanos();
        String message = new StringBuilder().append("Retrieved entry for [")
                .append(word)
                .append("] in ")
                .append(nanoSeconds / 1000000.0)
                .append("ms")
                .toString();
        logger.info(message);
        return entry;
    }

    @GetMapping("/getWordsThatContainSuccessiveLettersAndStartsWith/{chars}")
    public List<Entry> getWordsThatContainSuccessiveLettersAndStartsWith(@PathVariable String chars) {

        StopWatch sw = new StopWatch();
        sw.start();
        List<Entry> entries = service.getWordsThatContainSuccessiveLettersAndStartsWith(chars);  // mvp
        sw.stop();

        long nanoSeconds = sw.getLastTaskTimeNanos();
        String message = new StringBuilder().append("Retrieved entries for words with successive same letters ")
                .append("and containing [")
                .append(chars)
                .append("] characters in ")
                .append(nanoSeconds / 1000000.0)
                .append("ms")
                .toString();
        logger.info(message);

        return entries;
    }
}
