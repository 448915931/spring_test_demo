package com.tqf.config;

import com.tqf.domain.TestDomain;
import com.tqf.domain.TestDomain2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/16 0016 14:01
 * @Version 1.0
 */
//@Component
public class TestConfig {

	@Bean
	public TestDomain testDomain(){
		return new TestDomain();
	}

	@Bean
	public TestDomain2 testDomain2(){
		return new TestDomain2();
	}


}
