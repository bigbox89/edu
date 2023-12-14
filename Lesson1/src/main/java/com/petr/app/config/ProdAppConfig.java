package com.petr.app.config;

import com.petr.app.service.FileService;
import com.petr.app.service.impl.ProdFileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-prod.properties")
@Profile("prod")
public class ProdAppConfig {

    @Bean
    public FileService fileService(){
        return new ProdFileService();
    }
}
