package com.tqf.domain;

import org.springframework.stereotype.Component;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/16 0016 14:01
 * @Version 1.0
 */
@Component
public class TestDomain4 {

	public String sayHello(String name){
		return "你好，我是使用包扫描注入的对象："+name;
	}
}
