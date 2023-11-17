package com.example.aggregator.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"word",
"definition"
})
@Generated("jsonschema2pojo")
public class Example {

@JsonProperty("word")
private String word;
@JsonProperty("definition")
private String definition;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("word")
public String getWord() {
return word;
}

@JsonProperty("word")
public void setWord(String word) {
this.word = word;
}

@JsonProperty("definition")
public String getDefinition() {
return definition;
}

@JsonProperty("definition")
public void setDefinition(String definition) {
this.definition = definition;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}