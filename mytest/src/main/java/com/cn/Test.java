package com.cn;


import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class Test {

	/**
	 * spring-context包下加载xml文件
	 */
	private static void combineWithExpressionLanguage() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/bean.xml", Test.class);
		TestBean foo = applicationContext.getBean("foo", TestBean.class);
		TestBean bar = applicationContext.getBean("bar", TestBean.class);
		System.out.println(foo.getAge()+"---"+bar.getName());
	}

	/**
	 * spring-core包下加载配置文件
	 */
	private static void testXmlBeanFactory() {
		ClassPathResource classPathResource = new ClassPathResource("bean.xml");
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
		TestBean foo = (TestBean) xmlBeanFactory.getBean("foo");
		System.out.println(foo.getAge());
	}

	/**
	 * 调用的ClassPathResource获取配置文件和类加载器
	 */
	private static void testDefaultResourceLoader () {
		Resource resource = new DefaultResourceLoader().getResource("bean.xml");
		System.out.println(resource);
	}

	public static void main(String[] args) {
//		combineWithExpressionLanguage();
//		testXmlBeanFactory();
		testDefaultResourceLoader();
	}
}
