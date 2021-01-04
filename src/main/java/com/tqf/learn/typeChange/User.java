package com.tqf.learn.typeChange;


/**
 * @Author: 唐祺峰
 * @Date: 2020/12/22 0022 14:40
 * @Version 1.0
 */
//@Data
public class User {
	private Integer id;
	private String username;
	private String password;
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
