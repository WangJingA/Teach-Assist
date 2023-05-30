package com.boot.teach.common.config.minio;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MinIoClientConfig {
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint("http://192.168.219.137:9000").credentials("admin","admin123456").build();
    }
}
