package com.tqf.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/17 0017 9:41
 * @Version 1.0
 */
@Component
public class GlobalResource implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public static <T> T getBean(Class<T> requiredType) {
		return applicationContext.getBean(requiredType);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}

