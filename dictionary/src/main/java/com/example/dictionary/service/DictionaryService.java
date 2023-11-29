package com.example.dictionary.service;

import com.example.dictionary.exception.WordNotFoundException;
import com.example.dictionary.model.Entry;
import com.example.dictionary.reference.DictionaryReference;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {

    public Entry getWord(String word) throws WordNotFoundException {

        String definition = DictionaryReference.getDictionary().get(word);
        Entry entry = new Entry(word, definition);

        if(entry.getDefinition() == null) {
            throw new WordNotFoundException("Word [" + word + "] not found.");
        }

        return entry;

    }

}
