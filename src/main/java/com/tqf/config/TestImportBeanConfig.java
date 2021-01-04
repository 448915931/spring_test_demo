package com.tqf.config;

import com.tqf.selector.MyTestImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/17 0017 9:36
 * @Version 1.0
 */
@Configuration
@Import(MyTestImportSelector.class)
public class TestImportBeanConfig {
}
