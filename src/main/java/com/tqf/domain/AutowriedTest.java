package com.tqf.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: 唐祺峰
 * @Date: 2021/5/24 0024 11:00
 * @Version 1.0
 */
@Component
public class AutowriedTest {

	@Autowired
	public TestDomain3 testDomain3;

	public String getTest(){
		testDomain3.sayHello("我在测试Autowried注入！！");
		return "我在测试Autowried注入！！！";
	}

}
