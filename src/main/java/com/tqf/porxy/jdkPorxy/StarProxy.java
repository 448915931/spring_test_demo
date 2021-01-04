package com.tqf.porxy.jdkPorxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * @Author: 唐祺峰
 * @Date: 2020/12/21 0021 14:29
 * @Version 1.0
 */
public class StarProxy implements InvocationHandler {
	// 目标类，也就是被代理对象
	private Object target;

	public  StarProxy(Object target)
	{
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		// 这里可以做增强
		System.out.println("收钱");

		Object result = method.invoke(target, args);

		return result;
	}

	// 生成代理类
	public Object CreatProxyedObj()
	{
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

}