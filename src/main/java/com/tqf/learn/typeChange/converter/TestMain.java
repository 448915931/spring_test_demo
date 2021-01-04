package com.tqf.learn.typeChange.converter;

import com.tqf.learn.typeChange.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.List;
import java.util.Set;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/22 0022 14:04
 * @Version 1.0
 */
public class TestMain {
	public static void main(String[] args) {
//		new AnnotationConfigApplicationContext(UserConverter.class);
		ConversionService conversionService = new DefaultConversionService();
		((DefaultConversionService) conversionService).addConverter(new UserConverter());
		User userinfo = conversionService.convert("123-唐琦峰-123456-深圳", User.class);
		System.out.println(userinfo.getUsername());
		System.out.println(userinfo.getAddress());

		// String ==> Integer
		Integer num = conversionService.convert("12345", int.class);
		System.out.println("把字符串转化成数字"+num);
		// boolean ==> String
		String s = conversionService.convert(false, String.class);
		System.out.println("把布尔类型转化成字符串"+s);
		//String ==>List
		List<String> arrays = conversionService.convert("1,2,3", List.class);
		System.out.println("把字符串转化成列表"+arrays);

		String aa="12312";
		Integer vv=Integer.valueOf(aa);
		System.out.println(vv);
	}

}
