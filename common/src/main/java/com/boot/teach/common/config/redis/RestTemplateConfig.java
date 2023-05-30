package com.boot.teach.common.config.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author hzx
 * @date 2023/5/12
 */
@Configuration
public class RestTemplateConfig {

	@Bean
	//	@ConditionalOnMissingBean保证注册进容器的实例只有一个
	@ConditionalOnMissingBean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
