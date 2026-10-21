package com.yassine.employe.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Data
@Component
@ConfigurationProperties(prefix = "author")
public class authorConfig {
    private String name;
    private String email;
}

