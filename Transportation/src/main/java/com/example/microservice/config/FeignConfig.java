package com.example.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Decoder;
import feign.gson.GsonDecoder;

@Configuration
public class FeignConfig {

    @Bean
    public Decoder feignDecoder() {
        return new GsonDecoder();
    }

}
