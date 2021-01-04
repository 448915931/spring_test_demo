package com.tqf.config;

import com.tqf.aop.LogAspects;
import com.tqf.util.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/17 0017 16:06
 * @Version 1.0
 */

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

	//业务逻辑类加入容器中
	@Bean
	public MathCalculator calculator(){
		return new MathCalculator();
	}

	//切面类加入到容器中
	@Bean
	public LogAspects logAspects(){
		return new LogAspects();
	}
}
