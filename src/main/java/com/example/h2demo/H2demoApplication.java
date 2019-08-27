package com.example.h2demo;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RestController
public class H2demoApplication {
        public static void main(String[] args) {
                SpringApplication.run(H2demoApplication.class, args);
        }
		

    @PostMapping("/books")
    public void addBook(@RequestBody String str) {
        System.out.println("inside add book");
    }


      @Bean
      public CommonsRequestLoggingFilter logFilter() {
          CommonsRequestLoggingFilter filter
            = new CommonsRequestLoggingFilter();
          filter.setIncludeQueryString(true);
          filter.setIncludePayload(true);
          filter.setMaxPayloadLength(10000);
          filter.setIncludeHeaders(false);
          filter.setAfterMessagePrefix("REQUEST DATA : ");
          return filter;
      }

}

