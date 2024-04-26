package com.example.dictionary.service;

import com.example.dictionary.exception.WordNotFoundException;
import com.example.dictionary.model.Entry;
import com.example.dictionary.reference.DictionaryReference;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService {

    public Entry getWord(String word) throws WordNotFoundException {

        Map<String, String> dictionary = DictionaryReference.getDictionary();
        String definition = dictionary.get(word);
        Entry entry = new Entry(word, definition);

        return entry;
    }
}
