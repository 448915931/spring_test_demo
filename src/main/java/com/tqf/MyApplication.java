package com.tqf;

import com.myselfDi.TestDi;
import com.tqf.config.TestComponentScanConfig;
import com.tqf.di.IndependentDi;
import com.tqf.domain.*;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/16 0016 11:09
 * @Version 1.0
 */
public class MyApplication {

//	@Autowired
//	public static TestDomain2 testDomain2;


	public static void main(String[] args) {
		//方式1：使用XML配置注入bean
//		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		Hello hello = (Hello)ac.getBean("hello");
//		hello.sayHello();
		//方式2：指定类下面的注入注解，注入bean
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ctx.register(TestConfig.class);
//		ctx.refresh();
		//看源码，上面的三个步骤可以写成下面一个
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TestConfig.class);
//		TestDomain ent = (TestDomain)ctx.getBean("testDomain");
//		System.out.println(ent.sayHello("唐祺峰"));
//		TestDomain2 ent2 = (TestDomain2)ctx.getBean("testDomain2");
//		System.out.println(ent2.sayHello("唐祺峰2"));

//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TestDomain3.class);
//		TestDomain3 ent = (TestDomain3)ctx.getBean("testDomain3");
//		System.out.println(ent.sayHello("唐祺峰"));


//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanTestDomain6.class);
//		Hello ent = (Hello)ctx.getBean("hello");
//		ent.sayHello();
//		BeanTestDomain6 ent2 = (BeanTestDomain6)ctx.getBean("testDomain6");
//		ent2.testa();


		//方式3：注解注入bean，这里会报错，因为注解注入bean需要启动spring才行。
//		System.out.println(testDomain2.sayHello("唐祺峰"));

		//方式4：使用@Component注解+@ComponeneScan注解把所有bean放入Map容器中
		AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(TestComponentScanConfig.class);
		BeanTestDomain6 beanTestDomain6 = (BeanTestDomain6)applicationContext2.getBean("beanTestDomain6");
		beanTestDomain6.testa();
		Hello hello = (Hello)applicationContext2.getBean("hello");
		hello.sayHello();

		AutowriedTest autowriedTest = (AutowriedTest) applicationContext2.getBean("autowriedTest");
		autowriedTest.getTest();
//		//获取所有被注入容器的bean名称
		String[] definitionNames = applicationContext2.getBeanDefinitionNames();
 		for (String name : definitionNames) {
 			System.out.println(name);
		}

		try {
			IndependentDi.registerByClass(applicationContext2, "testDi", TestDi.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		definitionNames = applicationContext2.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
		TestDi testDi = (TestDi) applicationContext2.getBean("testDi");
		System.out.println(testDi.test());


		//测试aop切面
//		AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(TestComponentScanConfig.class);
//		MathCalculator mathCalculator = (MathCalculator)applicationContext2.getBean("mathCalculator");
//		mathCalculator.test();



		//方式4：使用ApplicationContextAware方式注入，必须放在包扫描下
//		TestDomain3 testDomain3 = GlobalResource.getBean(TestDomain3.class);
//		System.out.println(testDomain3.sayHello("唐祺峰332"));

		//方式5：使用ImportSelector方式注入
//		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(TestImportBeanConfig.class);
//		TestDomain5 testDomain5 = ctx2.getBean(TestDomain5.class);
//		System.out.println(testDomain5.sayHello("唐琦峰"));

	}
}
