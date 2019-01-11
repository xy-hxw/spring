package com.cn.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author huoxianwei
 * @date 2019/1/10 20:08
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	private static final Log logger = LogFactory.getLog(MyBeanPostProcessor.class);

	@Override
	public Object postProcessBeforeInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
		logger.info("04-->BeanPostProcessor postProcessBeforeInitialization  设置((MyBean) bean).setName(李四)");
		((MyBean) bean).setName("李四");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
		logger.info("07-->BeanPostProcessor postProcessAfterInitialization  设置((MyBean) bean).setAge(30)");
		((MyBean) bean).setAge(30);
		return bean;
	}
}
