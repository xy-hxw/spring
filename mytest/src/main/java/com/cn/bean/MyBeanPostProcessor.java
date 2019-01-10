package com.cn.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author huoxianwei
 * @date 2019/1/10 20:08
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	private static final Log logger = LogFactory.getLog(MyBeanPostProcessor.class);

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.info("调用  BeanPostProcessor ---> postProcessBeforeInitialization 获取到beanName="+beanName);
		((MyBean) bean).setName("李四");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		logger.info("调用  BeanPostProcessor ---> postProcessAfterInitialization 获取到beanName="+beanName);
		((MyBean) bean).setAge(30);
		return bean;
	}
}
