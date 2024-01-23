package com.example;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class SimpleParcelServiceAppWar extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SimpleParcelServiceApp.class);
    }

    public static void main(String[] args) {
        new SimpleParcelServiceAppWar()
                .configure(new SpringApplicationBuilder(SimpleParcelServiceApp.class))
                .run(args);
    }
}
