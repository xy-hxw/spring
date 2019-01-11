package com.cn.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author huoxianwei
 * @date 2019/1/11 18:33
 */
@Component
public class MyBeanConstruct {

	private static final Log logger = LogFactory.getLog(MyBeanPostProcessor.class);

	/**
	 * servlet容器init初始化方法之前执行
	 */
	@PostConstruct
	public void init() {
		logger.error("I am @PostConstruct init method");
	}

	public void test() {
		logger.info("I am @PostConstruct test method");
	}

	/**
	 * servlet容器destroy方法之后执行
	 */
	@PreDestroy
	public void destroy() {
		logger.info("I am @PostConstruct destroy method");
	}
}
