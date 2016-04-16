package com.baeldung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHypermediaApiApplication {

    // @Bean
    // public Jackson2ObjectMapperBuilder objectMapperBuilder() {
    // final Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    //
    // final FilterProvider filterProvider = new SimpleFilterProvider().addFilter("bookFilter", SimpleBeanPropertyFilter.filterOutAllExcept("title"));
    // builder.filters(filterProvider);
    //
    // return builder;
    // }

    //

    public static void main(String[] args) {
        SpringApplication.run(SpringHypermediaApiApplication.class, args);
    }
}
