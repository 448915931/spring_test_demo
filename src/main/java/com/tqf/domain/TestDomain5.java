package com.tqf.domain;

import org.springframework.stereotype.Component;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/16 0016 14:01
 * @Version 1.0
 */
public class TestDomain5 {

	public String sayHello(String name){
		return "你好，我是使用import注解注入bean："+name;
	}
}
