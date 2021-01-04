package com.tqf.learn.typeChange.propertyEditor;

import com.tqf.learn.typeChange.User;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/22 0022 14:25
 * @Version 1.0
 */
public class UserPropertyEditor extends PropertyEditorSupport {

//	@Override
//	public String getAsText() {
//		return null;
//	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text !=null){
			String[] vals= text.split("-");
			if(vals !=null && vals.length ==4){
				Integer id =Integer.parseInt(vals[0]);
				String username =vals[1];
				String password =vals[2];
				User user =new User();
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
				user.setAddress(password);
				setValue(user);
			}
		}
	}
}
