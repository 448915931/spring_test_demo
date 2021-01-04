package com.tqf.learn.typeChange.propertyEditor;

import com.tqf.learn.typeChange.User;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.PropertyEditorRegistrySupport;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.beans.PropertyEditor;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/22 0022 14:25
 * @Version 1.0
 */
public class TestMain {
	public static void main(String[] args) {
		PropertyEditorRegistry propertyEditorRegistry = new PropertyEditorRegistrySupport();
		//自定义一个User类型，并放入注册表中
		propertyEditorRegistry.registerCustomEditor(User.class, new UserPropertyEditor());
		PropertyEditor a=propertyEditorRegistry.findCustomEditor(User.class,null);
		a.setAsText("123-唐琦峰-123456-深圳");
		User user=(User) a.getValue();
		System.out.println(user.getUsername());
		System.out.println(user.getAddress());
	}
}
