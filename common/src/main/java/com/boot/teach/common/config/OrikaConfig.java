package com.boot.teach.common.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MapperFacade 用于dto ->entity的转换
 *
 * @author hzx
 * @date 2023/5/12
 */
@Configuration
public class OrikaConfig {

	@Bean
	public MapperFactory mapperFactory() {
		return new DefaultMapperFactory.Builder().build();
	}

	/**
	 * 使用facade可以将对象转换为另一个对象，方便开发
	 * 此处负责对象之间的映射
	 * @return
	 */
	@Bean
	public MapperFacade mapperFacade() {
		return mapperFactory().getMapperFacade();
	}

}
