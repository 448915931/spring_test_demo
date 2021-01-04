package com.tqf.porxy;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/21 0021 14:29
 * @Version 1.0
 */
public class LiuDeHua implements Star {
	@Override
	public String sing(String name)
	{
		System.out.println("给我一杯忘情水");

		return name+"唱完" ;
	}

	@Override
	public String dance(String name)
	{
		System.out.println("跳的像只猴子");

		return name+"跳完" ;
	}
}