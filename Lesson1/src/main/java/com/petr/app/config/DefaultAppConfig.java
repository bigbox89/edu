package com.petr.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("com.petr.app")
@Configuration
@PropertySource("classpath:application.properties")
public class DefaultAppConfig {
}