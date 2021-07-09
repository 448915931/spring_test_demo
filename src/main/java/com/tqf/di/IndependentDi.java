package com.tqf.di;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @Author: 唐祺峰
 * @Date: 2021/7/9 0009 9:11
 * @Version 1.0
 */
public class IndependentDi {


	/**
	 * 注册java源码代表的类到spring容器中
	 * @param applicationContext
	 * @param beanName
	 */
	public static void registerByClass(ApplicationContext applicationContext, String beanName, Class<?> clazz) throws ClassNotFoundException {

		/**
		 * 如果beanName传null，则赋值类的全限定名
		 */
		if(beanName == null) {
			beanName = clazz.getName();
		}

		/**
		 * 将applicationContext转换为ConfigurableApplicationContext
		 */
		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
		/**
		 * 获取bean工厂并转换为DefaultListableBeanFactory
		 */
		DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
		/**
		 * 万一已经有了这个BeanDefinition了，先remove掉,不然一次容器启动没法多次调用,这里千万别用成
		 * defaultListableBeanFactory.destroySingleton()了，BeanDefinition的注册只是放在了beanDefinitionMap中，还没有
		 * 放入到singletonObjects这个map中，所以不能用destroySingleton()，这个是没效果的
		 */
		if (defaultListableBeanFactory.containsBeanDefinition(beanName)) {
			defaultListableBeanFactory.removeBeanDefinition(beanName);
		}
		/**
		 * 使用spring的BeanDefinitionBuilder将Class对象转成BeanDefinition
		 */
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
		/**
		 * 以指定beanName注册上面生成的BeanDefinition
		 */
		defaultListableBeanFactory.registerBeanDefinition(beanName, beanDefinitionBuilder.getRawBeanDefinition());

	}


	/**
	 * 注册java源码代表的类到spring容器中
	 * @param applicationContext
	 * @param beanName
	 * @param src
	 */
	public static void register(ApplicationContext applicationContext, String beanName, String src) throws ClassNotFoundException {

		/**
		 * 使用动态类加载器载入java源码得到Class对象
		 */
		Class<?> clazz = DynamicClassLoader.load(src);

		/**
		 * 如果beanName传null，则赋值类的全限定名
		 */
		if(beanName == null) {
			beanName = clazz.getName();
		}

		/**
		 * 将applicationContext转换为ConfigurableApplicationContext
		 */
		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
		/**
		 * 获取bean工厂并转换为DefaultListableBeanFactory
		 */
		DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
		/**
		 * 万一已经有了这个BeanDefinition了，先remove掉,不然一次容器启动没法多次调用,这里千万别用成
		 * defaultListableBeanFactory.destroySingleton()了，BeanDefinition的注册只是放在了beanDefinitionMap中，还没有
		 * 放入到singletonObjects这个map中，所以不能用destroySingleton()，这个是没效果的
		 */
		if (defaultListableBeanFactory.containsBeanDefinition(beanName)) {
			defaultListableBeanFactory.removeBeanDefinition(beanName);
		}
		/**
		 * 使用spring的BeanDefinitionBuilder将Class对象转成BeanDefinition
		 */
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
		/**
		 * 以指定beanName注册上面生成的BeanDefinition
		 */
		defaultListableBeanFactory.registerBeanDefinition(beanName, beanDefinitionBuilder.getRawBeanDefinition());

	}


}
