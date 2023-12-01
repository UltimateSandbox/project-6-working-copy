package com.example.dictionary.controller;

import com.example.dictionary.exception.WordNotFoundException;
import com.example.dictionary.model.Entry;
import com.example.dictionary.service.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictionaryController {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryController.class);

    private final DictionaryService dictionaryService;

    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/getWord/{word}")
    public Entry getWord(@PathVariable String word) throws WordNotFoundException {

        StopWatch sw = new StopWatch();
        sw.start();
        Entry entry = this.dictionaryService.getWord(word);
        sw.stop();

        long nanoSeconds = sw.getLastTaskTimeNanos();
        String message = new StringBuilder("Retrieved entry for [")
                .append(word)
                .append("] in ")
                .append(nanoSeconds / 1000000.0)
                .append("ms")
                .toString();
        logger.info(message);
        return entry;
    }

    @GetMapping("/getWordsStartingWith/{value}")
    public List<Entry> getWordsStartingWith(@PathVariable String value) throws WordNotFoundException {

        StopWatch sw = new StopWatch();
        sw.start();
        List<Entry> entries = this.dictionaryService.getWordsStartingWith(value);
        sw.stop();

        long nanoSeconds = sw.getLastTaskTimeNanos();
        String message = new StringBuilder("Retrieved entries for words starting with [")
                .append(value)
                .append("] containing ")
                .append(entries.size())
                .append(" entries in ")
                .append(nanoSeconds / 1000000.0)
                .append("ms")
                .toString();
        logger.info(message);
        return entries;
    }

    @GetMapping("/getWordsThatContain/{value}")
    public List<Entry> getWordsThatContain(@PathVariable String value) throws WordNotFoundException {

        StopWatch sw = new StopWatch();
        sw.start();
        List<Entry> entries = this.dictionaryService.getWordsThatContain(value);
        sw.stop();

        long nanoSeconds = sw.getLastTaskTimeNanos();
        String message = new StringBuilder("Retrieved entries for words that contain [")
                .append(value)
                .append("] containing ")
                .append(entries.size())
                .append(" entries in ")
                .append(nanoSeconds / 1000000.0)
                .append("ms")
                .toString();
        logger.info(message);
        return entries;
    }

    @GetMapping("/getWordsThatContainConsecutiveLetters/{value}")
    public List<Entry> getWordsThatContainConsecutiveLetters(@PathVariable String value) throws WordNotFoundException {

        StopWatch sw = new StopWatch();
        sw.start();
        List<Entry> entries = this.dictionaryService.getWordsThatContainConsecutiveDoubleLetters(value);
        sw.stop();

        long nanoSeconds = sw.getLastTaskTimeNanos();
        String message = new StringBuilder("Retrieved entries for words that contain")
                .append(" consecutive double letters ")
                .append(" containing ")
                .append(entries.size())
                .append(" entries in ")
                .append(nanoSeconds / 1000000.0)
                .append("ms")
                .toString();
        logger.info(message);
        return entries;
    }

}
