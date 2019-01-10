package com.cn.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @author huoxianwei
 * @date 2019/1/10 18:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBean implements BeanNameAware {

	private static final Log logger = LogFactory.getLog(MyBean.class);

	private int age;
	private String name;
	private String sex;

	/**
	 * 如果Bean实现了BeanNameAware接口，则调用setBeanName(String name)返回beanName，
	 * 该方法不是设置beanName，而只是让Bean获取自己在BeanFactory配置中的名字
	 * @param name the name of the bean in the factory.
	 */
	@Override
	public void setBeanName(String name) {
		logger.info("01-->BeanNameAware 接口被调用，获取到的beanName="+name);
	}

	public void myDestroy () {
		logger.info("myDestroy 方法执行了");
	}

	public void myInit () {
		logger.info("myInit 方法执行了");
	}
}
