package com.tqf.learn.typeChange.converter;

import com.tqf.learn.typeChange.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @Author: 唐祺峰
 * @Role  		转换器
 * @Date: 2020/12/22 0022 14:41
 * @Version 1.0
 */

public class UserConverter implements Converter<String, User> {
	@Override
	public User convert(String src) {
		if(src !=null){
			String[] vals= src.split("-");
			if(vals !=null && vals.length ==4){
				Integer id =Integer.parseInt(vals[0]);
				String username =vals[1];
				String password =vals[2];
				User user =new User();
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
				user.setAddress(password);
				return user;
			}
		}
		return null;
	}
}
