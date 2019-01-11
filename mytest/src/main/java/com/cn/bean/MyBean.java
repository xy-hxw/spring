package com.cn.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * bean的生命周期
 * @author huoxianwei
 * @date 2019/1/10 18:43
 * --启动容器-->实例化bean对象-->设置对象属性-->调用BeanNameAware-->调用BeanFactoryAware-->调用ApplicationContextAware
 * 		    -->调用BeanPostProcessor(before)
 * 		   		-->调用InitializingBean  afterPropertiesSet
 * 		   		-->init-method
 * 		    -->调用BeanPostProcessor(after)
 * --容器关闭-->调用disposableBean  afterPropertiesSet-->调用destory-method
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

	private static final Log logger = LogFactory.getLog(MyBean.class);

	private int age;
	private String name;
	private String sex;
	private String beanName;

	/**
	 * 如果Bean实现了BeanNameAware接口，则调用setBeanName(String name)返回beanName，
	 * 该方法不是设置beanName，而只是让Bean获取自己在BeanFactory配置中的名字
	 * @param name the name of the bean in the factory.
	 */
	@Override
	public void setBeanName(@NotNull String name) {
		logger.info("01-->BeanNameAware 接口被调用，获取到的beanName="+name);
		this.beanName = name;
	}

	/**
	 * 如果Bean实现BeanFactoryAware接口，会回调该接口的setBeanFactory(BeanFactory beanFactory)方法，
	 * 传入该Bean的BeanFactory，这样该Bean就获得了自己所在的BeanFactory
	 * 如果Bean实现了ApplicationContextAware接
	 * @param beanFactory owning BeanFactory (never {@code null}).
	 * @throws BeansException
	 */
	@Override
	public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
		Object bean = beanFactory.getBean(beanName);
		logger.info("02-->BeanFactoryAware 接口被调用 beanFactory="+ bean);
	}

	/**
	 * 如果Bean实现了ApplicationContextAware接口
	 * 则调用该接口的setApplicationContext(ApplicationContext applicationContext)方法，设置applicationContext
	 * @param applicationContext the ApplicationContext object to be used by this object
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
		Object bean = applicationContext.getBean(beanName);
		logger.info("03-->ApplicationContextAware 接口被调用 applicationContext-->"+ bean);
	}

	/**
	 *
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("05-->InitializingBean 接口被调用");
	}

	public void myInit () {
		logger.info("06-->myInit 自定义初始化方法执行了");
	}

	/**
	 * 如果Bean实现了DisposableBean接口，则会回调该接口的destroy()方法销毁bean，
	 * @throws Exception
	 */
	@Override
	public void destroy() throws Exception {
		logger.info("09-->DisposableBean方法执行了");
	}

	public void myDestroy () {
		logger.info("10-->myDestroy 自定义销毁方法执行了");
	}
}
