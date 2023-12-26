package com.petr.app.config;

import com.petr.app.service.FileService;
import com.petr.app.service.impl.TestFileService;
import org.springframework.context.annotation.*;

@ComponentScan("com.petr.app")
@Configuration
@PropertySource("classpath:application.properties")
@Profile("default")
public class DefaultAppConfig {
    @Bean
    public FileService fileService() {
        return new TestFileService();
    }
}
