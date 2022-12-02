package com.example.dictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class DictionaryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext cxt = SpringApplication.run(DictionaryApplication.class, args);
        String[] beans = cxt.getBeanDefinitionNames();
        AtomicInteger counter = new AtomicInteger(1);
        Arrays.stream(beans)
              .sorted()
              .map(name -> counter.getAndIncrement() + ": " + name)
              .forEach(System.out::println);

    }

}
