package com.tqf.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/24 0024 17:47
 * @Version 1.0
 */
@Configuration
public class BeanTestDomain7 {

	@Bean
	public Hello2 hello2(){
		System.out.println("BeanTestDomain7我自动创建了");
		return new Hello2();
	}

	public void testa(){
		System.out.println("我是BeanTestDomain7方法");
	}

}
