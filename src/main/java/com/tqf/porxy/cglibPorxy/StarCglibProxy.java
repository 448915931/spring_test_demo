package com.tqf.porxy.cglibPorxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/21 0021 14:51
 * @Version 1.0
 */
public class StarCglibProxy implements MethodInterceptor {



	private Object target;// 被代理对象

	public StarCglibProxy(Object target) {
		this.target = target;
	}

	/**
	 * 创建代理对象
	 *
	 * @return
	 */
	public Object getProxyInstance() {
		Enhancer enhancer = new Enhancer();
		// 设置父类
		enhancer.setSuperclass(target.getClass());
		// 设置回调函数
		enhancer.setCallback(this);
		// 创建子类（代理对象）
		return enhancer.create();
	}

	/**
	 * obj		代理对象
	 * method	被代理对象的方法
	 * args		被代理对象的参数
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		//这里只改造被代理对象的save方法
		if ("dance".equals(method.getName())) {
			System.out.println("开始事务。。");
			// 执行被代理对象的方法
			Object invoke = method.invoke(target, args);
			System.out.println("提交事务。。");
			return invoke;
		}else{//其余方法按原样执行
			return method.invoke(target, args);
		}
	}
}
