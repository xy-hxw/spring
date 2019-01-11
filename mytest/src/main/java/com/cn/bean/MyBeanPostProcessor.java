package com.cn.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @author huoxianwei
 * @date 2019/1/10 20:08
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	private static final Log logger = LogFactory.getLog(MyBeanPostProcessor.class);

	@Override
	public Object postProcessBeforeInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
		logger.info("02-->BeanPostProcessor postProcessBeforeInitialization 获取到beanName="+beanName);
		((MyBean) bean).setName("李四");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
		logger.info("BeanPostProcessor postProcessAfterInitialization 获取到beanName="+beanName);
		((MyBean) bean).setAge(30);
		return bean;
	}
}
