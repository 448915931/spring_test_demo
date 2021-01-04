package com.tqf.porxy.cglibPorxy;

import com.tqf.porxy.LiuDeHua;
import com.tqf.porxy.Star;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/21 0021 14:54
 * @Version 1.0
 */
public class TestMain {

	public static void main(String[] args) {
		Star ldh = new LiuDeHua();
		//代理对象
		Star proxy = (Star) new StarCglibProxy(ldh).getProxyInstance();
		proxy.dance("牛德华");
		proxy.sing("牛德华");

	}

}
