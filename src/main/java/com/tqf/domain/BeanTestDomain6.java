package com.tqf.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/24 0024 17:47
 * @Version 1.0
 */
@Configuration
public class BeanTestDomain6 {

	@Bean
	public Hello hello(){
		System.out.println("我BeanTestDomain6自动创建了");
		return new Hello();
	}

	public void testa(){
		System.out.println("我是BeanTestDomain6方法");
	}

}
