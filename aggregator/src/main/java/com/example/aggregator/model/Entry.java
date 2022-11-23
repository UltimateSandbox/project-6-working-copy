package com.example.aggregator.model;

import java.util.Objects;

public class Entry implements Comparable<Entry> {

    private String word;
    private String definition;

    public Entry() {
    }

    public Entry(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(word, entry.word) && Objects.equals(definition, entry.definition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, definition);
    }

    @Override
    public int compareTo(Entry that) {
        return this.word.compareTo(that.word);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Entry{");
        sb.append("word='")
          .append(word)
          .append('\'');
        sb.append(", definition='")
          .append(definition)
          .append('\'');
        sb.append('}');
        return sb.toString();
    }
}
