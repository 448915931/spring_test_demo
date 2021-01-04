package com.tqf.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * @author 唐祺峰
 * @Date: 2020/12/17 0017 15:58
 * @Aspect： 告诉Spring当前类是一个切面类
 * @Version 1.0
 */
@Aspect
@Component
public class LogAspects {

	//抽取公共的切入点表达式
	//1、本类引用
	//2、其他的切面引用
	@Pointcut("execution(public * com.tqf.util.MathCalculator.test())")
	public void recordLog(){}

	//通知方法
	@Before("recordLog()")
	public void before() {
		this.printLog("已经记录下操作日志@Before 方法执行前");
	}
	//通知方法
	@Around("recordLog()")
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		this.printLog("已经记录下操作日志@Around 方法执行前");
		pjp.proceed();
		this.printLog("已经记录下操作日志@Around 方法执行后");
	}
	//通知方法
	@After("recordLog()")
	public void after() {
		this.printLog("已经记录下操作日志@After 方法执行后");
	}

	private void printLog(String str){
		System.out.println(str);
	}
}
