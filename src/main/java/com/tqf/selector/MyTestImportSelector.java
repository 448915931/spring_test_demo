package com.tqf.selector;

import com.tqf.domain.TestDomain5;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: 唐祺峰
 * @Date: 2020/12/17 0017 9:26
 * @Version 1.0
 */
public class MyTestImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{TestDomain5.class.getName()};
	}
}
