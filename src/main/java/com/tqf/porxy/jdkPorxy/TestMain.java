package com.tqf.porxy.jdkPorxy;

import com.tqf.porxy.LiuDeHua;
import com.tqf.porxy.Star;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/21 0021 14:30
 * @Version 1.0
 */
public class TestMain {
	public static void main(String[] args) {
		Star ldh = new LiuDeHua();

		StarProxy proxy = new StarProxy(ldh);

		Star star = (Star) proxy.CreatProxyedObj();

		star.dance("牛德华");
		star.sing("牛德华");

	}
}
