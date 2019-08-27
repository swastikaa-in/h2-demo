package com.demo.example.h2demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.context.annotation.Bean;


@Configuration
public class LogConfig {
  
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
