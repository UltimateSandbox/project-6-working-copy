package com.example.aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class AggregatorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext cxt = SpringApplication.run(AggregatorApplication.class, args);
        String[] beans = cxt.getBeanDefinitionNames();
        AtomicInteger counter = new AtomicInteger(1);
        Arrays.stream(beans)
              .sorted()
              .filter(name -> name.toLowerCase()
                                  .contains("rest"))
              .map(name -> counter.getAndIncrement() + ": " + name)
              .forEach(System.out::println);
    }

}
